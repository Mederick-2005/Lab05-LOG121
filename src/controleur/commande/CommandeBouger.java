package controleur.commande;
import Modele.ImagePerspective;

public class CommandeBouger extends CommandePerspective{
    private double valeurX, valeurY;
    private ImagePerspective imageSelec;

    public CommandeBouger(double ValeurX, double ValeurY, ImagePerspective imageSelec) {
        this.valeurX = ValeurX;
        this.valeurY = ValeurY;
        this.imageSelec = imageSelec;
    }

    /**
     * Déplacement de l'image
     */
    public void executer(){
        double ancienneValeurX = imageSelec.getDeplacementX();
        double ancienneValeurY = imageSelec.getDeplacementY();
        imageSelec.mouvement(ancienneValeurX + valeurX, ancienneValeurY + valeurY);
    }

    /**
     * Annulation du déplacement en faisant le déplacement inverse
     */
    public void annuler(){
        double ancienneValeurX = imageSelec.getDeplacementX();
        double ancienneValeurY = imageSelec.getDeplacementY();
        imageSelec.mouvement(ancienneValeurX - valeurX, ancienneValeurY - valeurY);
    }
}
