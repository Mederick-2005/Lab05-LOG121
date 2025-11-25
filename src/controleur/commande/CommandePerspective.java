package controleur.commande;

import Modele.ImagePerspective;

public abstract class CommandePerspective extends CommandeModele{
    private ImagePerspective imageSelec;

    public ImagePerspective getImageSelec(){
        return imageSelec;
    }
}
