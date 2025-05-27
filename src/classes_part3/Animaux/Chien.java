package classes_part3.Animaux;

public class Chien
        extends Animal {

    public Chien(String nom) {
        super(nom);
    }

    public void crier() {
        System.out.println("Le chien " + getNom() + " aboie.");
    }

    // Méthode spécifique à la classe Chien
    public void comportement() {
        System.out.println("Le chien " + getNom() + " joue avec une balle.");
    }

}
