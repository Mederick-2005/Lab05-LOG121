package Modele;

import controleur.memento.MementoImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImagePrincipale extends SujetModele implements Image{

    private java.awt.Image image;
    private double zoom = 1.0;
    private double deplacementX = 0.0;
    private double deplacementY = 0.0;

    /**
     * Contructeur pr défaut pour une imgae prncipale
     */
    public ImagePrincipale(){
        this.image = null;
        this.zoom = 1.0;
        this.deplacementX = 0;
        this.deplacementY = 0;
    }

    /**
     * Permet de charger une image
     * @param file fichier contenant l'image
     */
    public void chargerImage(File file){
        try{
            this.image = ImageIO.read(file);
            notifierObservateur(new EvenementModele(TypeEvenement.CHARGER));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour retourner le zoom de l'image
     * @return  Le zoom
     */
    @Override
    public double getZoom() {
        return zoom;
    }

    /**
     * Fonction pour retourner le déplacement en X de l'image
     * @return  Le déplacement en X
     */
    @Override
    public double getDeplacementX() {
        return deplacementX;
    }

    /**
     * Fonction pour retourner le déplacement en Y de l'image
     * @return  Le déplacement en Y
     */
    @Override
    public double getDeplacementY() {
        return deplacementY;
    }

    /**
     * Fonction pour retourner l'imgae
     * @return  L'image
     */
    @Override
    public java.awt.Image getImage() {
        return image;
    }

    /**
     * Fonction pour définir l'image et notifier ses observateurs
     * @param image  L'image concerné
     */
    public void setImage(java.awt.Image image) {
        this.image = image;
        notifierObservateur(new EvenementModele(TypeEvenement.CHARGER));
    }
}
