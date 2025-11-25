package Modele;

import java.io.File;

//Interface de l'image principale et des perspectives.
public interface Image {
    public double getZoom();
    public double getDeplacementX();
    public double getDeplacementY();
    public java.awt.Image getImage();
}
