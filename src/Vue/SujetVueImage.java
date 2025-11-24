package Vue;

import controleur.ObservateurControleurImage;

import java.util.ArrayList;
import java.util.List;



public abstract class SujetVueImage {

    protected List<ObservateurControleurImage> observateurs = new ArrayList<>();

    public void ajouterObservateur(ObservateurControleurImage o) {
        if (!observateurs.contains(o)) {
            observateurs.add(o);
        }
    }

    public void retirerObservateur(ObservateurControleurImage o) {
        observateurs.remove(o);
    }

    protected void notifierClic() {
        for (ObservateurControleurImage o : observateurs) {
            o.reactionClicSelection();
        }
    }

    protected void notifierMouvement(double mouvementX, double mouvementY) {
        for (ObservateurControleurImage o : observateurs) {
            o.reactionMouvement();
        }
    }

    protected void notifierZoom(double rotationMolette) {
        for (ObservateurControleurImage o : observateurs) {
            o.reactionZoom();
        }
    }
}
