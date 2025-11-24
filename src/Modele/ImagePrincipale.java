package Modele;

import controleur.memento.MementoImage;

public class ImagePrincipale extends SujetModele implements Image{

    private Image image;
    private double zoom;
    private double deplacementX;
    private double deplacementY;

    public ImagePrincipale(){
        this.image = null;
        this.zoom = 0;
        this.deplacementX = 0;
        this.deplacementY = 0;
    }

    public void chargerImage(){

    }

    public MementoImage creerMemento(){

        return null;
    }

    public void restaurer(MementoImage memento){

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

    protected void notifierObservateur(EvenementModele e){

    }
}
