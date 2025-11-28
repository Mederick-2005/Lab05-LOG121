package controleur.commande;

import Modele.ImagePerspective;

public class CommandeZoom extends CommandePerspective{
    private double niveauZoom;
    private ImagePerspective imageSelec;

    public CommandeZoom(double niveauZoom, ImagePerspective imageSelec) {
        this.niveauZoom = niveauZoom;
        this.imageSelec = imageSelec;
    }

    /**
     * exécute la zoom
     */
    public void executer(){
        double ancienZoom = imageSelec.getZoom();
        imageSelec.setZoom(ancienZoom + niveauZoom);
    }

    /**
     * Annule le zoom en faisant un zoom de la valeur inverse du zoom initial
     */
    public void annuler(){
        double ancienZoom = imageSelec.getZoom();
        imageSelec.setZoom(ancienZoom - niveauZoom);
    }
}
