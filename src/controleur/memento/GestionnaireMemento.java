package controleur.memento;

import Modele.ImagePerspective;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GestionnaireMemento {
    private Stack<MementoImage> historique = new Stack<>();
    private static GestionnaireMemento instance;

    /**
     * Constructeur du gestionnaire de memento
     */
    private GestionnaireMemento() {
    }

    /**
     * Permet d'obtenir l'instance du singleton gestionnaire de memento
     * @return l'instance du GestionnaireMemento
     */
    public static GestionnaireMemento getInstance() {
        if (instance == null) {
            instance = new GestionnaireMemento();
        }
        return instance;
    }

    /**
     * Redonne l'état de la dernière sauvegarde de l'historique à la perspective concernée
     */
    public void refaire(){
        MementoImage dernierMemento = historique.pop();
        ImagePerspective dernierImage = dernierMemento.getImageSource();
        dernierImage.restaurerMemento(dernierMemento);
    }

    /**
     * Ajoute un memento (sauvegarde) à l'historique
     * @param m memento à ajouter
     */
    public void ajouterHistorique(MementoImage m){
        historique.push(m);
    }

    /**
     * vérifie si l'historique est vide
     * @return vrai si vide
     */
    public boolean estVide(){
        return historique.isEmpty();
    }

    /**
     * vide l'historique du gestionnaire
     */
    public void viderHistorique(){
        historique.clear();
    }
}
