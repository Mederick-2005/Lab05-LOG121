package controleur.commande;
import Modele.ImagePerspective;

public class CommandeBouger extends CommandePerspective{
    private double valeurX, valeurY;

    public CommandeBouger(double ValeurX, double ValeurY, ImagePerspective imageSelec) {
        super(imageSelec);
        this.valeurX = ValeurX;
        this.valeurY = ValeurY;
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
    @Override
    public void annuler(){
        double ancienneValeurX = imageSelec.getDeplacementX();
        double ancienneValeurY = imageSelec.getDeplacementY();
        imageSelec.mouvement(ancienneValeurX - valeurX, ancienneValeurY - valeurY);
    }
}
