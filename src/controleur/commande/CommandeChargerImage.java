package controleur.commande;

import controleur.controleurInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CommandeChargerImage {
    public CommandeChargerImage() {
        JFileChooser chooser = new JFileChooser();
        int resultat = chooser.showOpenDialog(null);

        if(resultat == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            controleurInterface.getModelePrincipale().chargerImage(file);
            controleurInterface.getModelePerspective1().chargerImage(file);
            controleurInterface.getModelePerspective2().chargerImage(file);
        }
    }
    public void executer(){}
    public void annuler(){}
}
