package controleur;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;
import Vue.VueEntiere;
import controleur.commande.CommandeChargerImage;
import controleur.commande.CommandeEnregistrerPerspective;

import javax.swing.*;
import java.io.File;

public class controleurInterface implements ObservateurControleurInterface {

    private static ImagePrincipale modelePrincipale;
    private static ImagePerspective modelePerspective1;
    private static ImagePerspective modelePerspective2;

    public controleurInterface(VueEntiere vueEntiere,ImagePrincipale imgPrinc,ImagePerspective imgPersp1,ImagePerspective imgPersp2) {
        vueEntiere.ajouterObservateur(this);
        this.modelePrincipale = imgPrinc;
        this.modelePerspective1 = imgPersp1;
        this.modelePerspective2 = imgPersp2;
    }

    public static ImagePrincipale getModelePrincipale() {
        return modelePrincipale;
    }

    public static ImagePerspective getModelePerspective1() {
        return modelePerspective1;
    }
    public static ImagePerspective getModelePerspective2() {
        return modelePerspective2;
    }

    @Override
    public void reactionClicBouton(JButton bouton) {
        System.out.println("Contrôleur : clic sur " + bouton.getText());

        switch (bouton.getText()) {
            case "Charger Image":
                new CommandeChargerImage();
                break;

            case "Sauvegarder":
                String cheminProjet = System.getProperty("user.dir") + File.separator + "sauvegarde.ser";
                new CommandeEnregistrerPerspective(modelePrincipale, modelePerspective1, modelePerspective2, cheminProjet).executer();
                break;

            case "Défaire":
                //defaire();
                break;

            case "Refaire":
                //refaire();
                break;

            case "Charger Perspective":
                //chargerPerspective();
                break;
        }

    }
}
