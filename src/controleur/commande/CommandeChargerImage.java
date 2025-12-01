package controleur.commande;

import controleur.controleurInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CommandeChargerImage extends CommandeModele{
    public CommandeChargerImage() {
        JFileChooser chooser = new JFileChooser();
        int resultat = chooser.showOpenDialog(null);

        if(resultat == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            controleurInterface.getModelePrincipale().chargerImage(file);

            controleurInterface.getModelePerspective1().chargerImage(file);
            controleurInterface.getModelePerspective1().setZoom(1);
            controleurInterface.getModelePerspective1().mouvement(0,0);

            controleurInterface.getModelePerspective2().chargerImage(file);
            controleurInterface.getModelePerspective2().setZoom(1);
            controleurInterface.getModelePerspective2().mouvement(0,0);
        }
    }
    public void executer(){}
}
