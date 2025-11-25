package Modele;

import Vue.ObservateurVue;

import java.util.ArrayList;
import java.util.List;

public abstract class SujetModele {
    private List<ObservateurVue> observateurs = new ArrayList<>();

    public void ajouterObservateur(ObservateurVue observateur){
        observateurs.add(observateur);
    }
    public void retirerObservateur(ObservateurVue observateur){
        observateurs.remove(observateur);
    }

    protected  void notifierObservateur(EvenementModele e){
        for (ObservateurVue observateur : observateurs) {
            observateur.mettreAJour(e);
        }
    };

}
