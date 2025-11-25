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

    public ImagePrincipale(){
        //Tout est nul ou 0 lors de la construction car aucune image n'a été chargée
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


    public void restaurer(MementoImage memento){

    }

    @Override
    public double getZoom() {
        return zoom;
    }

    @Override
    public double getDeplacementX() {
        return deplacementX;
    }

    @Override
    public double getDeplacementY() {
        return deplacementY;
    }

    @Override
    public java.awt.Image getImage() {
        return image;
    }

    public void setImage(java.awt.Image image) {
        this.image = image;
        notifierObservateur(new EvenementModele(TypeEvenement.CHARGER));
    }
}
