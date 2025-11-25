package Vue;

import Modele.EvenementModele;
import Modele.ImagePerspective;
import javax.swing.*;
import java.awt.*;

public class VueImagePerspective extends SujetVueImage implements ObservateurVue{

    private ImagePerspective modele;
    private double dernierX, dernierY;

    public VueImagePerspective() {
        this.modele = new ImagePerspective();
        this.modele.ajouterObservateur(this);
        setBackground(new Color(240, 240, 240));

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notifierClic(VueImagePerspective.this);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dernierX = evt.getX();
                dernierY = evt.getY();
            }
        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
           @Override
           public void mouseDragged(java.awt.event.MouseEvent evt) {
               double dx  = evt.getX() - dernierX;
               double dy  = evt.getY() - dernierY;

               dernierX = evt.getX();
               dernierY = evt.getY();
               notifierMouvement(VueImagePerspective.this, dx, dy);
           }
        });

        addMouseWheelListener(e ->  {
             double rotation = e.getWheelRotation();
            notifierZoom(rotation);
        });
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

    public ImagePerspective getModele() {
        return modele;
    }
}
