package Modele;

import Vue.ObservateurVue;

import java.util.ArrayList;
import java.util.List;

public abstract class SujetModele {
    private List<ObservateurVue> observateurs = new ArrayList<>();

    /**
     * Ajoute un observateur au sujet
     * @param observateur observateur ajouté
     */
    public void ajouterObservateur(ObservateurVue observateur){
        observateurs.add(observateur);
    }

    /**
     * Retire un observateur au sujet
     * @param observateur observateur retiré
     */
    public void retirerObservateur(ObservateurVue observateur){
        observateurs.remove(observateur);
    }

    /**
     * Notifie les vues abonnées au sujet.
     * @param e type d'événement (de modification) qui a été effectuée sur le modèle
     */
    protected  void notifierObservateur(EvenementModele e){
        for (ObservateurVue observateur : observateurs) {
            observateur.mettreAJour(e);
        }
    };

}
