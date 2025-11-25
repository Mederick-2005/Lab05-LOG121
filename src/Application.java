import Modele.*;
import Vue.*;
import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        ImagePrincipale imgPrinc = new ImagePrincipale();
        ImagePerspective imgPersp1 = new ImagePerspective();
        ImagePerspective imgPersp2 = new ImagePerspective();

        JFrame fenetre = new JFrame("Application Photo et perspective");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1000, 600);

        VueEntiere vueEntiere = new VueEntiere();
        vueEntiere.repaint();

        fenetre.setContentPane(vueEntiere);
        fenetre.setVisible(true);
    }
}