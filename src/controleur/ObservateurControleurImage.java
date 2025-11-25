package controleur;

import Vue.SujetVueImage;

public interface ObservateurControleurImage {
    void reactionClicSelection(SujetVueImage sujet);
    void reactionMouvement(SujetVueImage sujet, double mouvementX, double mouvementY);
    void reactionZoom(double rotationMolette);
}
