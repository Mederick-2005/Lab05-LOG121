package Vue;

import Modele.EvenementModele;
import Modele.ImagePrincipale;
import javax.swing.*;
import java.awt.*;


public class VueImagePrincipale extends JPanel implements ObservateurVue {

    private ImagePrincipale modele;

    public VueImagePrincipale(ImagePrincipale modele) {
        this.modele = modele;
        this.modele.ajouterObservateur(this);

        setBackground(new Color(230, 230, 230));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modele != null && modele.getImage() != null) {
            Graphics2D g2d = (Graphics2D) g;
            // Amélioration du rendu (anti-aliasing) pour que ce soit plus joli
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            java.awt.Image image = modele.getImage();

            int panelWidth = this.getWidth();
            int panelHeight = this.getHeight();

            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);

            double ratioX = (double) panelWidth / imageWidth;
            double ratioY = (double) panelHeight / imageHeight;

            double scale = Math.min(ratioX, ratioY) * modele.getZoom();

            int newWidth = (int) (imageWidth * scale);
            int newHeight = (int) (imageHeight * scale);

            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;

            x += (int) modele.getDeplacementX();
            y += (int) modele.getDeplacementY();

            g2d.drawImage(image, x, y, newWidth, newHeight, this);

        } else {
            g.drawString("Vue Principale: Aucune Image", 20, 20);
        }
    }


    @Override
    public void mettreAJour(EvenementModele e) {
        repaint();
    }
}
