package controleur;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;
import Vue.VueEntiere;
import controleur.commande.*;
import controleur.memento.GestionnaireMemento;

import javax.swing.*;
import java.io.File;

public class controleurInterface implements ObservateurControleurInterface {

    private static ImagePrincipale modelePrincipale;
    private static ImagePerspective modelePerspective1;
    private static ImagePerspective modelePerspective2;

    /**
     * Constructeur pour le controleur de l'interface et de la gestion des boutons
     * @param vueEntiere  La vue complete qui contient toutes les autres vues
     * @param imgPrinc  L'image principale
     * @param imgPersp1  La première image perspective
     * @param imgPersp2  La deuxième image perspective
     */
    public controleurInterface(VueEntiere vueEntiere,ImagePrincipale imgPrinc,ImagePerspective imgPersp1,ImagePerspective imgPersp2) {
        vueEntiere.ajouterObservateur(this);
        this.modelePrincipale = imgPrinc;
        this.modelePerspective1 = imgPersp1;
        this.modelePerspective2 = imgPersp2;
    }

    //Getter pour les images
    public static ImagePrincipale getModelePrincipale() {
        return modelePrincipale;
    }
    public static ImagePerspective getModelePerspective1() {
        return modelePerspective1;
    }
    public static ImagePerspective getModelePerspective2() {
        return modelePerspective2;
    }

    /**
     * Fonction pour effectuer la commande en lien avec le bouton qui a été cliqué
     * @param bouton  Le bouton qui a été cliqué
     */
    @Override
    public void reactionClicBouton(JButton bouton) {
        System.out.println("Contrôleur : clic sur " + bouton.getText());

        switch (bouton.getText()) {
            case "Charger Image":
                new CommandeChargerImage().executer();
                break;

            case "Sauvegarder":
                new CommandeEnregistrerPerspective(modelePrincipale, modelePerspective1, modelePerspective2).executer();
                break;

            case "Défaire":
                defaire();
                break;

            case "Refaire":
                refaire();
                break;

            case "Charger Perspective":
                new CommandeChargerPerspective(modelePrincipale, modelePerspective1, modelePerspective2).executer();
                break;
        }
    }

    /**
     * annule la dernière commande de l'historique du gestionnaire de commande
     */
    public void defaire(){
        //On retire la dernière commande du gestionnaire
        GestionnaireCommandes instanceGestComm = GestionnaireCommandes.getInstance();
        if(!instanceGestComm.estVide()){
            CommandePerspective derniereCommande = instanceGestComm.retirerHistorique();
            //On crée un Memento avant d'annuler la dernière commande (pour pouvoir redo)
            ImagePerspective perspectiveDerCom = derniereCommande.getImageSelec();
            perspectiveDerCom.creerMemento();
            //On annulle la commande
            derniereCommande.annuler();
        }
    }

    /**
     * refait une action défaite en restaurant l'état d'avant le undo
     */
    public void refaire(){
        GestionnaireMemento instanceMemento = GestionnaireMemento.getInstance();
        if(!instanceMemento.estVide()){
            instanceMemento.refaire();
        }
    }
}
