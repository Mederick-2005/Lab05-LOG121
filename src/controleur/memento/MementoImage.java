package controleur.memento;

import Modele.ImagePerspective;

import java.io.File;

public class MementoImage {
    private File image;
    private double zoom;
    private double deplacementX;
    private double deplacementY;
    private ImagePerspective imageSource; //perspective sur laquelle la sauvegarde a été faite

    public MementoImage(File image, double zoom, double deplacementX, double deplacementY, ImagePerspective imageSource) {
        this.image = image;
        this.zoom = zoom;
        this.deplacementX = deplacementX;
        this.deplacementY = deplacementY;
        this.imageSource = imageSource;
    }

    public File getImage() {
        return image;
    }
    public double getZoom() {
        return zoom;
    }
    public double getDeplacementX() {
        return deplacementX;
    }
    public double getDeplacementY() {
        return deplacementY;
    }
    public ImagePerspective getImageSource() {
        return imageSource;
    }
}
