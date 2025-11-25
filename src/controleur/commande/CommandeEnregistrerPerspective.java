package controleur.commande;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;
import controleur.memento.MementoImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class CommandeEnregistrerPerspective extends CommandeModele {

    private ImagePrincipale modelePrincipal;
    private ImagePerspective modeleP1;
    private ImagePerspective modeleP2;
    private String cheminFichier;

    public CommandeEnregistrerPerspective(ImagePrincipale princ, ImagePerspective p1, ImagePerspective p2, String chemin) {
        this.modelePrincipal = princ;
        this.modeleP1 = p1;
        this.modeleP2 = p2;
        this.cheminFichier = chemin;
    }

    @Override
    public void executer() {

            try {

                byte[] imageEnOctets = null;
                BufferedImage imageSwing = (BufferedImage) modelePrincipal.getImage();

                if (imageSwing != null) {
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    ImageIO.write(imageSwing, "png", byteArray);
                    imageEnOctets = byteArray.toByteArray();
                    byteArray.close();
                }

                try (FileOutputStream fichierSortie = new FileOutputStream(new File(cheminFichier));
                     ObjectOutputStream objetSortie = new ObjectOutputStream(fichierSortie)) {

                    objetSortie.writeObject(imageEnOctets);

                    objetSortie.writeDouble(modeleP1.getZoom());
                    objetSortie.writeDouble(modeleP1.getDeplacementX());
                    objetSortie.writeDouble(modeleP1.getDeplacementY());

                    objetSortie.writeDouble(modeleP2.getZoom());
                    objetSortie.writeDouble(modeleP2.getDeplacementX());
                    objetSortie.writeDouble(modeleP2.getDeplacementY());

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
