package Modele;

import controleur.memento.GestionnaireMemento;
import controleur.memento.MementoImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImagePerspective extends SujetModele implements Image{

    private java.awt.Image image;
    private double zoom = 1.0;
    private double deplacementX = 0.0;
    private double deplacementY = 0.0;

    public ImagePerspective(){
        //Tout est nul ou 0 car aucune image n'a été chargé
        this.image = null;
        this.zoom = 1;
        this.deplacementX = 0;
        this.deplacementY = 0;
    }

    /**
     * Change la source de l'image et notifie les vues
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
     * changer la valeur du zoom sur la perspective et notifie les vues
     * @param zoom valeur du zoom
     */
    public void setZoom(double zoom){
        this.zoom = zoom;
        notifierObservateur(new EvenementModele(TypeEvenement.ZOOM_MODIF));
    }

    /**
     * Change la position de la perspective et notifie les vues
     * @param x nouvelle position horizontale
     * @param y nouvelle position verticale
     */
    public void mouvement(double x,double y){
        this.deplacementX = x;
        this.deplacementY = y;
        notifierObservateur(new EvenementModele(TypeEvenement.DEPLACE));
    }

    /**
     * Crée une sauvegarde de la perspective et l'enregistre dans l'historique du gestionnaire de Memento
     */
    public void creerMemento(){
        MementoImage m = new MementoImage(image, zoom, deplacementX, deplacementY, this);
        GestionnaireMemento instance = GestionnaireMemento.getInstance();
        instance.ajouterHistorique(m);
    }

    /**
     * Restaure les données d'un memento dans l'image perspective et notifie les vues
     * @param memento Memento contenant l'état à restaurer.
     */
    public void restaurerMemento(MementoImage memento){
        image = memento.getImageSource().getImage();
        zoom = memento.getZoom();
        deplacementX = memento.getDeplacementX();
        deplacementY = memento.getDeplacementY();
        notifierObservateur(new EvenementModele(TypeEvenement.REDO));
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

    public void setImage(java.awt.Image image) {this.image = image;}
}
