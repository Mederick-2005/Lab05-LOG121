package Vue;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import controleur.ObservateurControleurInterface;

public abstract class SujetVueInterface {

    protected List<ObservateurControleurInterface> observateurs = new ArrayList<>();

    public void ajouterObservateur(ObservateurControleurInterface observateur) {
        if (!observateurs.contains(observateur)) {
            observateurs.add(observateur);
        }
    }

    public void retirerObservateur(ObservateurControleurInterface observateur) {observateurs.remove(observateur);}

    protected void notifierClic(Button source) {
        for (ObservateurControleurInterface o : observateurs) {
            o.reactionClicBouton(source);
        }
    }
}
