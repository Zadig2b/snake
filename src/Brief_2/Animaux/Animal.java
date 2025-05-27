package Brief_2.Animaux;

// Objectif : Créer une classe Animal puis des classes filles Chien et Chat, chacune redéfinissant une méthode crier().
public class Animal {
    private String nom;

    public Animal(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode crier() à redéfinir dans les classes filles
    public void crier() {
        System.out.println("L'animal " + nom + " fait un bruit.");
    }

    public void comportement(){

    }

}
