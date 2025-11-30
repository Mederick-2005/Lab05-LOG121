package controleur.commande;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class CommandeChargerPerspective extends CommandeModele{

    private File fichier;
    private ImagePrincipale imagePrincipale;
    private ImagePerspective imagePerspective1;
    private ImagePerspective imagePerspective2;

    // Constructeur
    public CommandeChargerPerspective(File f, ImagePrincipale ip, ImagePerspective ip1, ImagePerspective ip2) {
        this.fichier = f;
        this.imagePrincipale = ip;
        this.imagePerspective1 = ip1;
        this.imagePerspective2 = ip2;
    }

    // Création d'un objet FileInputStream pour charger une image et 2 perspective à partire d'un fichier
    // préalablement créer par la commande charger perspective
    public void executer() {
        try (FileInputStream fichierEntree = new FileInputStream(fichier);
             ObjectInputStream ObjetEntree = new ObjectInputStream(fichierEntree)) {

            byte[] imageBytes = (byte[]) ObjetEntree.readObject();

            // Si le fichier existe alors on peut le charger
            if (imageBytes != null) {

                ByteArrayInputStream tableauByte = new ByteArrayInputStream(imageBytes);
                BufferedImage imgRecuperee = ImageIO.read(tableauByte);

                imagePrincipale.setImage(imgRecuperee);
                imagePerspective1.setImage(imgRecuperee);
                imagePerspective2.setImage(imgRecuperee);
            }

            double z1 = ObjetEntree.readDouble();
            double x1 = ObjetEntree.readDouble();
            double y1 = ObjetEntree.readDouble();

            imagePerspective1.setZoom(z1);
            imagePerspective1.mouvement(x1, y1);

            double z2 = ObjetEntree.readDouble();
            double x2 = ObjetEntree.readDouble();
            double y2 = ObjetEntree.readDouble();

            imagePerspective2.setZoom(z2);
            imagePerspective2.mouvement(x2, y2);

            System.out.println("Chargement réussi!");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Impossible de lire le fichier de sauvegarde");
        }

    }
    public void annuler(){}
}
