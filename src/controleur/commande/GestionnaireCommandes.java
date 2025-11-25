package controleur.commande;

import java.util.Stack;

public class GestionnaireCommandes {
    private static GestionnaireCommandes instance;
    private Stack<CommandePerspective> historique = new Stack<>(); //Seulement les CommandePerspective sont annulables

    private GestionnaireCommandes() {}

    public static GestionnaireCommandes getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommandes();
        }
        return instance;
    }

    public void ajouterHistorique(CommandePerspective commande) {
        historique.push(commande);
    }

    public CommandePerspective retirerHistorique(){
        return historique.pop();
    }
}
