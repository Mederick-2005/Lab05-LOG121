package controleur;

import javax.swing.*;
import java.awt.*;

public interface ObservateurControleurInterface {
    /**
     * Lorsqu'un bouton est cliqué la fonction est appelé
     * @param bouton  Le bouton qui a été cliqué
     */
    public void reactionClicBouton(JButton bouton);
}
