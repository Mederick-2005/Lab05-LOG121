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
                defaire();
                break;

            case "Refaire":
                refaire();
                break;

            case "Charger Perspective":
                String cheminChargement = System.getProperty("user.dir") + File.separator + "sauvegarde.ser";
                File fichierALire = new File(cheminChargement);

                if (fichierALire.exists()) {
                    new CommandeChargerPerspective(fichierALire, modelePrincipale, modelePerspective1, modelePerspective2).executer();
                } else {
                    System.out.println("Aucun fichier de sauvegarde trouvé à cet emplacement.");
                }
                break;
        }
    }

    /**
     * annule la dernière commande de l'historique du gestionnaire de commande
     */
    public void defaire(){
        //On retire la dernière commande du gestionnaire
        GestionnaireCommandes instanceGestComm = GestionnaireCommandes.getInstance();
        CommandePerspective derniereCommande = instanceGestComm.retirerHistorique();
        //On crée un Memento avant d'annuler la dernière commande (pour pouvoir redo)
        ImagePerspective perspectiveDerCom = derniereCommande.getImageSelec();
        perspectiveDerCom.creerMemento();
        //On annulle la commande
        derniereCommande.annuler();
    }

    /**
     * refait une action défaite en restaurant l'état d'avant le undo
     */
    public void refaire(){
        GestionnaireMemento instanceMemento = GestionnaireMemento.getInstance();
        instanceMemento.refaire();
    }
}
