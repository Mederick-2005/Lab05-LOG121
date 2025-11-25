package controleur.commande;

import java.util.Stack;

public class GestionnaireCommandes {
    private static GestionnaireCommandes instance;
    private Stack<CommandeModele> historique = new Stack<>();

    private GestionnaireCommandes() {}

    public static GestionnaireCommandes getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommandes();
        }
        return instance;
    }

    public void ajouterHistorique(CommandeModele commande) {
        historique.push(commande);
    }

    public CommandeModele retirerHistorique(){
        return historique.pop();
    }
}
