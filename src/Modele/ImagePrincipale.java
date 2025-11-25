package Modele;

import controleur.memento.MementoImage;

import java.io.File;

public class ImagePrincipale extends SujetModele implements Image{

    private File image;
    private double zoom;
    private double deplacementX;
    private double deplacementY;

    public ImagePrincipale(){
        this.image = null;
        this.zoom = 0;
        this.deplacementX = 0;
        this.deplacementY = 0;
    }

    public void chargerImage(File file){
        this.image = file;
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
    public File getImage() {
        return image;
    }
}
