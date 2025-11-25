package Modele;

import controleur.memento.MementoImage;

import java.io.File;

public class ImagePerspective extends SujetModele implements Image{

    private File image;
    private double zoom;
    private double deplacementX;
    private double deplacementY;

    public ImagePerspective(){
        this.image = null;
        this.zoom = 0;
        this.deplacementX = 0;
        this.deplacementY = 0;
    }

    public void chargerImage(File file){
        this.image = file;
        notifierObservateur(new EvenementModele(TypeEvenement.CHARGER));
    }

    public void setZoom(double zoom){
        this.zoom = zoom;
        notifierObservateur(new EvenementModele(TypeEvenement.ZOOM_MODIF));
    }

    public void mouvement(double x,double y){
        this.deplacementX = x;
        this.deplacementY = y;
        notifierObservateur(new EvenementModele(TypeEvenement.DEPLACE));
    }

    public MementoImage creerMemento(){
        return new MementoImage(image, zoom, deplacementX, deplacementY, this);
    }

    public void restaurerMemento(MementoImage memento){
        image = memento.getImage();
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
    public File getImage() {
        return image;
    }
}
