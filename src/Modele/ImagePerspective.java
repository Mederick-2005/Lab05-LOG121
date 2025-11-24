package Modele;

import controleur.memento.MementoImage;

public class ImagePerspective extends SujetModele implements Image{

    private Image image;
    private double zoom;
    private double deplacementX;
    private double deplacementY;

    public ImagePerspective(){}

    public void setZoom(double zoom){
        this.zoom = zoom;
    }

    public void mouvement(double x,double y){
        this.deplacementX = x;
        this.deplacementY = y;
    }

    public MementoImage creerMemento(){
        return null;
    }

    public void restaurerMemento(MementoImage memento){

    }


    @Override
    public double getZoom() {
        return 0;
    }

    @Override
    public double getDeplacementX() {
        return 0;
    }

    @Override
    public double getDeplacementY() {
        return 0;
    }

    @Override
    public Image getImage() {
        return null;
    }
}
