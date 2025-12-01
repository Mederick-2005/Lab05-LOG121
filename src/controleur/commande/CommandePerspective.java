package controleur.commande;

import Modele.ImagePerspective;

//Commandes qui servent à modifier l'état des perspectives et qui sont annulables (zoom et deplacement)
public abstract class CommandePerspective extends CommandeModele{
    protected ImagePerspective imageSelec;

    public CommandePerspective(ImagePerspective imageSelec) {
        this.imageSelec = imageSelec;
    }

    public ImagePerspective getImageSelec(){
        return imageSelec;
    }

    public abstract void annuler();
}
