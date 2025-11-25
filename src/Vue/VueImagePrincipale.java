package Vue;

import Modele.EvenementModele;
import Modele.ImagePrincipale;
import javax.swing.*;
import java.awt.*;
import java.io.File;


public class VueImagePrincipale extends JPanel implements ObservateurVue {

    private ImagePrincipale modele;

    public VueImagePrincipale() {
        this.modele = new ImagePrincipale();
        this.modele.ajouterObservateur(this);

        setBackground(new Color(230, 230, 230));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modele != null && modele.getImage() != null) {
            Graphics2D g2d = (Graphics2D) g;
            java.awt.Image image = modele.getImage();

            int width = (int) (image.getWidth(this) * modele.getZoom());
            int height = (int) (image.getHeight(this) * modele.getZoom());
            int x = (int) modele.getDeplacementX();
            int y = (int) modele.getDeplacementY();

            g2d.drawImage(image, x, y, width, height, this);
        } else {
            g.drawString("Vue Principale: Aucune Image", 20, 20);
        }
    }


    @Override
    public void mettreAJour(EvenementModele e) {
        repaint();
    }
}
