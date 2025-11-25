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

            // 1. Récupérer les dimensions de la zone d'affichage (le JPanel)
            int panelWidth = this.getWidth();
            int panelHeight = this.getHeight();

            // 2. Récupérer les dimensions de l'image réelle
            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);

            // 3. Calculer le ratio pour que l'image rentre DANS la fenêtre (Fit to Screen)
            // On cherche quel côté bloque (largeur ou hauteur)
            double ratioX = (double) panelWidth / imageWidth;
            double ratioY = (double) panelHeight / imageHeight;

            // On prend le plus petit ratio pour être sûr que tout rentre
            // Multiplié par le zoom du modèle (ainsi zoom=1.0 veut dire "adapté à l'écran")
            double scale = Math.min(ratioX, ratioY) * modele.getZoom();

            // 4. Calculer la nouvelle taille affichée
            int newWidth = (int) (imageWidth * scale);
            int newHeight = (int) (imageHeight * scale);

            // 5. Calculer la position pour CENTRER l'image
            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;

            // 6. Ajouter le déplacement (pan) du modèle
            x += (int) modele.getDeplacementX();
            y += (int) modele.getDeplacementY();

            // 7. Dessiner
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
