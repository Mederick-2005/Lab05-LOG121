package controleur.memento;

import Modele.ImagePerspective;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GestionnaireMemento {
    private Stack<MementoImage> historique = new Stack<>();
    private static GestionnaireMemento instance;

    private GestionnaireMemento() {
    }

    public static GestionnaireMemento getInstance() {
        if (instance == null) {
            instance = new GestionnaireMemento();
        }
        return instance;
    }

    public void refaire(){
        MementoImage dernierMemento = historique.pop();
        ImagePerspective dernierImage = dernierMemento.getImageSource();
        dernierImage.restaurerMemento(dernierMemento);
    }

    public void ajouterHistorique(MementoImage m){
        historique.push(m);
    }
}
