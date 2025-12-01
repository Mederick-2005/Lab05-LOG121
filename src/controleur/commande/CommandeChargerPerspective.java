package controleur.commande;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.*;

public class CommandeChargerPerspective extends CommandeModele {

    private ImagePrincipale imagePrincipale;
    private ImagePerspective imagePerspective1;
    private ImagePerspective imagePerspective2;

    /**
     * Constructeur de la commande pour charger une image et ses perspectives dans ceux qui on été sauvegarder
     * @param ip  Image principale
     * @param ip1 Image perspective 1
     * @param ip2 Image perspective 2
     */
    public CommandeChargerPerspective(ImagePrincipale ip, ImagePerspective ip1, ImagePerspective ip2) {
        this.imagePrincipale = ip;
        this.imagePerspective1 = ip1;
        this.imagePerspective2 = ip2;
    }

    /**
     * Fonction pour exécuter la commande
     */
    @Override
    public void executer() {
        File dossierSauvegarde = new File("Sauvegarde");

        JFileChooser fileChooser = new JFileChooser(dossierSauvegarde);

        fileChooser.setDialogTitle("Ouvrir une sauvegarde");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de sauvegarde (.ser)", "ser"));

        int resultat = fileChooser.showOpenDialog(null);

        if (resultat == JFileChooser.APPROVE_OPTION) {
            File fichierSelectionne = fileChooser.getSelectedFile();
            chargerFichier(fichierSelectionne);
        }
    }

    /**
     * Fonction pour chargé le fichier de sauvegarde choisi par l'utilisateur
     * @param fichier  Le fichier choisi
     */
    private void chargerFichier(File fichier) {
        try (FileInputStream fichierEntree = new FileInputStream(fichier);
             ObjectInputStream ObjetEntree = new ObjectInputStream(fichierEntree)) {

            byte[] imageBytes = (byte[]) ObjetEntree.readObject();

            if (imageBytes != null) {
                ByteArrayInputStream tableauByte = new ByteArrayInputStream(imageBytes);
                BufferedImage imgRecuperee = ImageIO.read(tableauByte);

                imagePrincipale.setImage(imgRecuperee);
                imagePerspective1.setImage(imgRecuperee);
                imagePerspective2.setImage(imgRecuperee);
            }

            // Lecture P1
            double z1 = ObjetEntree.readDouble();
            double x1 = ObjetEntree.readDouble();
            double y1 = ObjetEntree.readDouble();
            imagePerspective1.setZoom(z1);
            imagePerspective1.mouvement(x1, y1);

            // Lecture P2
            double z2 = ObjetEntree.readDouble();
            double x2 = ObjetEntree.readDouble();
            double y2 = ObjetEntree.readDouble();
            imagePerspective2.setZoom(z2);
            imagePerspective2.mouvement(x2, y2);

            System.out.println("Chargement réussi du fichier : " + fichier.getName());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Impossible de lire le fichier de sauvegarde.");
        }
    }
}