package Vue;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import controleur.ObservateurControleurInterface;

import javax.swing.*;

public abstract class SujetVueInterface extends JPanel {

    // Liste des observateurs de l'interface
    protected List<ObservateurControleurInterface> observateurs = new ArrayList<>();

    /**
     * Fonction pour ajouter un observateur à la liste
     * @param observateur  Observateur à ajouter
     */
    public void ajouterObservateur(ObservateurControleurInterface observateur) {
        if (!observateurs.contains(observateur)) {
            observateurs.add(observateur);
        }
    }

    /**
     * Fonction pour retirer un observateurs de la liste
     * @param observateur   Observateur à retirer
     */
    public void retirerObservateur(ObservateurControleurInterface observateur) {observateurs.remove(observateur);}

    /**
     * Fonction pour notifier les observteurs qu'il y a eu un clic sur un certain bouton
     * @param source  Le bouton qui a été cliqué
     */
    protected void notifierClic(JButton source) {
        for (ObservateurControleurInterface o : observateurs) {
            o.reactionClicBouton(source);
        }
    }
}
