package controleur.commande;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;
import controleur.memento.MementoImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class CommandeEnregistrerPerspective extends CommandeModele {

    private ImagePrincipale imagePrincipale;
    private ImagePerspective imagePerspective1;
    private ImagePerspective imagePerspective2;
    private String cheminFichier;

    public CommandeEnregistrerPerspective(ImagePrincipale princ, ImagePerspective p1, ImagePerspective p2, String chemin) {
        this.imagePrincipale = princ;
        this.imagePerspective1 = p1;
        this.imagePerspective2 = p2;
        this.cheminFichier = chemin;
    }

    @Override
    public void executer() {

            try {

                byte[] imageEnOctets = null;
                BufferedImage imageSwing = (BufferedImage) imagePrincipale.getImage();

                if (imageSwing != null) {
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    ImageIO.write(imageSwing, "png", byteArray);
                    imageEnOctets = byteArray.toByteArray();
                    byteArray.close();
                }

                try (FileOutputStream fichierSortie = new FileOutputStream(new File(cheminFichier));
                     ObjectOutputStream objetSortie = new ObjectOutputStream(fichierSortie)) {

                    objetSortie.writeObject(imageEnOctets);

                    objetSortie.writeDouble(imagePerspective1.getZoom());
                    objetSortie.writeDouble(imagePerspective1.getDeplacementX());
                    objetSortie.writeDouble(imagePerspective1.getDeplacementY());

                    objetSortie.writeDouble(imagePerspective2.getZoom());
                    objetSortie.writeDouble(imagePerspective2.getDeplacementX());
                    objetSortie.writeDouble(imagePerspective2.getDeplacementY());

                    System.out.println("Sauvegarde réussie : " + cheminFichier);
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Erreur lors de la sauvegarde.");
            }
        }


    @Override
    public void annuler() {
    }
}
