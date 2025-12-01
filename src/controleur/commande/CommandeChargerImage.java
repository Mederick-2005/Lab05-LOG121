package controleur.commande;

import controleur.controleurInterface;
import controleur.memento.GestionnaireMemento;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CommandeChargerImage extends CommandeModele{
    /**
     * Constructeur pour la commande charger une image
     */
    public CommandeChargerImage() {

    }

    /**
     * Fonction qui permet de parcourir les fichiers de l'ordinateur de l'utilisateur pour choisir le fichier à charger
     */
    public void executer(){
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

            GestionnaireMemento.getInstance().viderHistorique();
            GestionnaireCommandes.getInstance().viderHistorique();
        }
    }
}
