package Brief_2.Animaux;

public class Chat extends Animal {
    //  Objectif : Créer une classe Chat qui hérite de la classe Animal et
    // redéfinit la méthode crier().
    public Chat(String nom) {
        super(nom);
    }

    // Méthode crier() à redéfinir dans les classes filles
    public void crier() {
        System.out.println("Le chat " + getNom() + " miaule.");
    }

    // Méthode spécifique à la classe Chat
    public void comportement() {
        System.out.println("Le chat " + getNom() + " chasse une souris.");
    }
}
