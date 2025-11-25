package controleur.commande;

import java.io.File;

public class CommandeChargerPerspective extends CommandeModele{

    private File fichier;

    public CommandeChargerPerspective(File fichier) {
        this.fichier = fichier;
    }


    public void executer() {

    }
    public void annuler(){}
}
