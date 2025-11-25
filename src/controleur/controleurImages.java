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

    public void setImageSelec(SujetVueImage image) {
        if (image instanceof VueImagePerspective){
            imageSelec = ((VueImagePerspective) image).getModele();
        }
    }

    @Override
    public void reactionClicSelection(SujetVueImage sujet) {
        setImageSelec(sujet);
    }

    @Override
    public void reactionMouvement(SujetVueImage sujet, double mouvementX, double mouvementY){
        if (sujet instanceof VueImagePerspective) {
            ImagePerspective modele = ((VueImagePerspective) sujet).getModele();
            CommandePerspective commande = new CommandeBouger(mouvementX, mouvementY, modele);
            commande.executer();

            GestionnaireCommandes instanceGestionnaire = GestionnaireCommandes.getInstance();
            instanceGestionnaire.ajouterHistorique(commande);
        }
    }

    @Override
    public void reactionZoom(double rotationMolette){
        CommandePerspective commande = new CommandeZoom(rotationMolette, imageSelec);
        commande.executer();

        GestionnaireCommandes instanceGestionnaire = GestionnaireCommandes.getInstance();
        instanceGestionnaire.ajouterHistorique(commande);
    }
}
