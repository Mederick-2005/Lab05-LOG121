package controleur;

import Modele.ImagePerspective;
import Modele.ImagePrincipale;
import Vue.SujetVueImage;
import Vue.VueImagePerspective;
import controleur.commande.*;

public class controleurImages implements ObservateurControleurImage{
    private ImagePrincipale modelePrincipale;
    private ImagePerspective modelePerspective1;
    private ImagePerspective modelePerspective2;
    private ImagePerspective imageSelec;

    public controleurImages(ImagePrincipale modelePrincipale, ImagePerspective modelePerspective1, ImagePerspective modelePerspective2) {
        this.modelePrincipale = modelePrincipale;
        this.modelePerspective1 = modelePerspective1;
        this.modelePerspective2 = modelePerspective2;
        this.imageSelec = modelePerspective1;
    }

    /**
     * Change l'image qui est sélectionnée dans l'app (pour le zoom)
     * @param image image (vue) sélectionnée
     */
    public void setImageSelec(SujetVueImage image) {
        if (image instanceof VueImagePerspective){
            imageSelec = ((VueImagePerspective) image).getModele();
        }
    }

    /**
     * Réagit au clic sur une image
     * @param sujet vue sur laquelle il y a eu un clic
     */
    @Override
    public void reactionClicSelection(SujetVueImage sujet) {
        setImageSelec(sujet);
    }

    /**
     * réagit à un drag and drop sur une image
     * @param sujet image (vue) sur laquelle il y a eu un mouvement
     * @param mouvementX deplacement horizontal de la sourie
     * @param mouvementY deplacement vertical de la sourie
     */
    @Override
    public void reactionMouvement(SujetVueImage sujet, double mouvementX, double mouvementY){
        if (sujet instanceof VueImagePerspective) {
            //création et gestion de la commande
            ImagePerspective modele = ((VueImagePerspective) sujet).getModele();
            CommandePerspective commande = new CommandeBouger(mouvementX, mouvementY, modele);
            commande.executer();
            //ajout de la commande à l'historique du gestionnaire de commandes
            GestionnaireCommandes instanceGestionnaire = GestionnaireCommandes.getInstance();
            instanceGestionnaire.ajouterHistorique(commande);
        }
    }

    /**
     * réagit à un mouvement de la molette de la sourie
     * @param rotationMolette degré de rotation de la molette
     */
    @Override
    public void reactionZoom(double rotationMolette){
        //Les conditions servent à éviter un zoom négatif
        if(imageSelec.getZoom()==0.01 && rotationMolette<=0){
            //On ne fait rien si on est déjà à la limite du négatif et qu'on veut dézoom
            return;
        } else if ((imageSelec.getZoom()+rotationMolette)<=0) {
            //Si on atteint la limite lors du zoom, on met le zoom à la limite (0,01)
            //création et gestion de la commande
            CommandePerspective commande = new CommandeZoom(0.01-imageSelec.getZoom(), imageSelec);
            commande.executer();
            //ajout de la commande à l'historique du gestionnaire de commandes
            GestionnaireCommandes instanceGestionnaire = GestionnaireCommandes.getInstance();
            instanceGestionnaire.ajouterHistorique(commande);
        } else {
            //Sinon le comportement est normal
            //création et gestion de la commande
            CommandePerspective commande = new CommandeZoom(rotationMolette, imageSelec);
            commande.executer();
            //ajout de la commande à l'historique du gestionnaire de commandes
            GestionnaireCommandes instanceGestionnaire = GestionnaireCommandes.getInstance();
            instanceGestionnaire.ajouterHistorique(commande);
        }

    }
}
