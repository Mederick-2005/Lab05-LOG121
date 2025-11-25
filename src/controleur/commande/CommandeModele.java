package controleur.commande;

import Modele.ImagePerspective;

import java.awt.*;

public abstract class CommandeModele { ;

    public CommandeModele() {}

    public abstract void executer();

    public abstract void annuler();
}
