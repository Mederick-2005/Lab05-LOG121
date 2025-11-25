package Modele;

//Sert à savoir quel type de modification a été fait au modèle lors de la notification des vues
public class EvenementModele {
    private TypeEvenement type;

    public EvenementModele(TypeEvenement type) {
        this.type = type;
    }
    public TypeEvenement getType() {
        return type;
    }
}
