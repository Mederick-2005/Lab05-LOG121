package controleur.commande;

import java.util.Stack;

public class GestionnaireCommandes {
    private static GestionnaireCommandes instance;
    private Stack<CommandePerspective> historique = new Stack<>(); //Seulement les CommandePerspective sont annulables

    private GestionnaireCommandes() {}

    /**
     * accès à l'instance du gestionnaire de commandes
     * @return l'instance du gestionnaire
     */
    public static GestionnaireCommandes getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommandes();
        }
        return instance;
    }

    /**
     * Ajoute une commande à l'historique
     * @param commande commande à ajouter
     */
    public void ajouterHistorique(CommandePerspective commande) {
        historique.push(commande);
    }

    /**
     * retire la dernière commande de l'historique
     * @return la commande retirée
     */
    public CommandePerspective retirerHistorique(){
        return historique.pop();
    }
}
