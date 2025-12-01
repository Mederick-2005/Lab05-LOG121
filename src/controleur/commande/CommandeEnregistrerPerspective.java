package controleur.commande;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.*;

public class CommandeEnregistrerPerspective extends CommandeModele {

    private ImagePrincipale imagePrincipale;
    private ImagePerspective imagePerspective1;
    private ImagePerspective imagePerspective2;

    /**
     * Constructeur pour une commande de sauvegarde d'une image et des ses perspectives
     * @param princ  L'image principale
     * @param p1   Image perspective 1
     * @param p2   Image perspective 2
     */
    public CommandeEnregistrerPerspective(ImagePrincipale princ, ImagePerspective p1, ImagePerspective p2) {
        this.imagePrincipale = princ;
        this.imagePerspective1 = p1;
        this.imagePerspective2 = p2;
    }

    /**
     * Fonction pour exécuter la commande
     */
    @Override
    public void executer() {
        File dossierSauvegarde = new File("Sauvegarde");

        if (!dossierSauvegarde.exists()) {
            dossierSauvegarde.mkdir();
        }

        JFileChooser fileChooser = new JFileChooser(dossierSauvegarde);

        fileChooser.setDialogTitle("Enregistrer la perspective");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de sauvegarde (.ser)", "ser"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String chemin = fileToSave.getAbsolutePath();

            if (!chemin.endsWith(".ser")) {
                chemin += ".ser";
                fileToSave = new File(chemin);
            }

            try {
                byte[] imageEnOctets = null;
                BufferedImage imageSwing = (BufferedImage) imagePrincipale.getImage();

                if (imageSwing != null) {
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    ImageIO.write(imageSwing, "png", byteArray);
                    imageEnOctets = byteArray.toByteArray();
                    byteArray.close();
                }

                try (FileOutputStream fichierSortie = new FileOutputStream(fileToSave);
                     ObjectOutputStream objetSortie = new ObjectOutputStream(fichierSortie)) {

                    objetSortie.writeObject(imageEnOctets);

                    // Perspective 1
                    objetSortie.writeDouble(imagePerspective1.getZoom());
                    objetSortie.writeDouble(imagePerspective1.getDeplacementX());
                    objetSortie.writeDouble(imagePerspective1.getDeplacementY());

                    // Perspective 2
                    objetSortie.writeDouble(imagePerspective2.getZoom());
                    objetSortie.writeDouble(imagePerspective2.getDeplacementX());
                    objetSortie.writeDouble(imagePerspective2.getDeplacementY());

                    System.out.println("Sauvegarde réussie : " + chemin);
                    JOptionPane.showMessageDialog(null, "Sauvegarde réussie !");
                }

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur lors de la sauvegarde : " + e.getMessage());
            }
        }
    }
}