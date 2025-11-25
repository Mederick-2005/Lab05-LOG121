package Vue;

import controleur.ObservateurControleurImage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;



public abstract class SujetVueImage extends JPanel {

    protected List<ObservateurControleurImage> observateurs = new ArrayList<>();

    /**
     * Permet d'ajouter un observateur (controleur) à la vue
     * @param o observateur à ajouter
     */
    public void ajouterObservateur(ObservateurControleurImage o) {
        if (!observateurs.contains(o)) {
            observateurs.add(o);
        }
    }

    /**
     * Permet de retirer un observateur (controleur) à la vue
     * @param o observateur à retirer
     */
    public void retirerObservateur(ObservateurControleurImage o) {
        observateurs.remove(o);
    }

    /**
     * Notifie l'observateur des images qu'il y a eu un clic sur les images
     * @param sujet la vue sur lequel il y a eu un clic
     */
    protected void notifierClic(SujetVueImage sujet) {
        for (ObservateurControleurImage o : observateurs) {
            o.reactionClicSelection(sujet);
        }
    }

    /**
     * Notifie l'observateur des images qu'il y a eu un mouvement sur les images.
     * @param sujet la vue sur lequel il y a eu un mouvement
     * @param mouvementX
     * @param mouvementY
     */
    protected void notifierMouvement(SujetVueImage sujet, double mouvementX, double mouvementY) {
        for (ObservateurControleurImage o : observateurs) {
            o.reactionMouvement(sujet, mouvementX, mouvementY);
        }
    }

    protected void notifierZoom(double rotationMolette) {
        for (ObservateurControleurImage o : observateurs) {
            o.reactionZoom(rotationMolette);
        }
    }
}
