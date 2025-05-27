package classes_part3.Employe;

public class TestSalaires {
    //  implémenter classe de test d'après les classes Employe, Freelance et Salaire
    public static void main(String[] args) {
        Salarie employe = new Salarie("John Doe", 2500.0);
        Freelance freelance = new Freelance("Jane Smith", 5, 20.0);
        Salarie salaire = new Salarie("Bob Johnson", 3000.0);

        System.out.println("Salaire de " + employe.getNom() + ": " + employe.calculerSalaire());
        System.out.println("Salaire de " + freelance.getNom() + ": " + freelance.calculerSalaire());
        System.out.println("Salaire de " + salaire.getNom() + ": " + salaire.calculerSalaire());
    }
    
}
