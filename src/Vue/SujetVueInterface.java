package Vue;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import controleur.ObservateurControleurInterface;

import javax.swing.*;

public abstract class SujetVueInterface extends JPanel {

    protected List<ObservateurControleurInterface> observateurs = new ArrayList<>();

    public void ajouterObservateur(ObservateurControleurInterface observateur) {
        if (!observateurs.contains(observateur)) {
            observateurs.add(observateur);
        }
    }

    public void retirerObservateur(ObservateurControleurInterface observateur) {observateurs.remove(observateur);}

    protected void notifierClic(JButton source) {
        for (ObservateurControleurInterface o : observateurs) {
            o.reactionClicBouton(source);
        }
    }
}
