package controleur;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;
import Vue.VueEntiere;
import controleur.commande.CommandeChargerImage;

import javax.swing.*;

public class controleurInterface implements ObservateurControleurInterface {

    private static ImagePrincipale modelePrincipale;
    private ImagePerspective modelePerspective1;
    private ImagePerspective modelePerspective2;

    public controleurInterface(VueEntiere vueEntiere,ImagePrincipale imgPrinc,ImagePerspective imgPersp1,ImagePerspective imgPersp2) {
        vueEntiere.ajouterObservateur(this);
        this.modelePrincipale = imgPrinc;
        this.modelePerspective1 = imgPersp1;
        this.modelePerspective2 = imgPersp2;
    }

    public static ImagePrincipale getModelePrincipale() {
        return modelePrincipale;
    }

    @Override
    public void reactionClicBouton(JButton bouton) {
        System.out.println("Contrôleur : clic sur " + bouton.getText());

        switch (bouton.getText()) {
            case "Charger Image":
                new CommandeChargerImage();
                break;

            case "Sauvegarder":
                //sauvegarderPerspective();
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
