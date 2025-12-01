package controleur.memento;

import Modele.ImagePerspective;

import java.io.File;

public class MementoImage {
    private java.awt.Image image;
    private double zoom;
    private double deplacementX;
    private double deplacementY;
    private ImagePerspective imageSource; //perspective sur laquelle la sauvegarde a été faite

    /**
     * Constructeur pour créer un memento de l'image voulu
     * @param image  Image à partir de laquelle créer le memento
     * @param zoom  zoom de l'image
     * @param deplacementX  déplacement en X de l'image
     * @param deplacementY  déplacement en Y de l'image
     * @param imageSource   Image perspective
     */
    public MementoImage(java.awt.Image image, double zoom, double deplacementX, double deplacementY, ImagePerspective imageSource) {
        this.image = image;
        this.zoom = zoom;
        this.deplacementX = deplacementX;
        this.deplacementY = deplacementY;
        this.imageSource = imageSource;
    }

    // Getters
    public java.awt.Image getImage() {
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
