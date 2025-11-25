package Vue;

import Modele.EvenementModele;
import Modele.ImagePerspective;
import javax.swing.*;
import java.awt.*;

public class VueImagePerspective extends SujetVueImage implements ObservateurVue{

    private ImagePerspective modele;

    public VueImagePerspective() {
        this.modele = new ImagePerspective();
        this.modele.ajouterObservateur(this);

        setBackground(new Color(240, 240, 240));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modele != null && modele.getImage() != null) {
            Graphics2D g2d = (Graphics2D) g;
            java.awt.Image img = modele.getImage();

            int width = (int) (img.getWidth(this) * modele.getZoom());
            int height = (int) (img.getHeight(this) * modele.getZoom());
            int x = (int) modele.getDeplacementX();
            int y = (int) modele.getDeplacementY();

            g2d.drawImage(img, x, y, width, height, this);
        } else {
            g.drawString("Perspective: Vide", 20, 20);
        }
    }


    @Override
    public void mettreAJour(EvenementModele e) {
        repaint();
    }
}
