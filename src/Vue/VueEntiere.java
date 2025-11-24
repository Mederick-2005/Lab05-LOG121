package Vue;

import Modele.SujetModele;

import java.awt.*;

public class VueEntiere implements ObservateurVue{

    private Button btnChargerImage;
    private Button btnEnregistrerPerspective;
    private Button btnRefaire;
    private Button btnDefaire;
    private Button btnChargerPerspective;
    private VueImagePrincipale imagePrincipale;
    private VueImagePerspective imagePerspective1;
    private VueImagePerspective imagePerspective2;

    @Override
    public void mettreAJour(SujetModele sujet) {

    }
}
