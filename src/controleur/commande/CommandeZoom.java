package controleur.commande;

import Modele.ImagePerspective;

public class CommandeZoom extends CommandePerspective{
    private double nouveauZoom;

    /**
     * Constructeur pour la commande zoom
     * @param nouveauZoom
     * @param imageSelec  Image sur laquelle le zoom est effectuer
     */
    public CommandeZoom(double nouveauZoom, ImagePerspective imageSelec) {
        super(imageSelec);
        this.nouveauZoom = nouveauZoom;
    }

    /**
     * exécute le zoom
     */
    public void executer(){
        double ancienZoom = imageSelec.getZoom();
        imageSelec.setZoom(ancienZoom + nouveauZoom);
    }

    /**
     * Annule le zoom en faisant un zoom de la valeur inverse du zoom initial
     */
    @Override
    public void annuler(){
        double ancienZoom = imageSelec.getZoom();
        imageSelec.setZoom(ancienZoom - nouveauZoom);
    }
}
