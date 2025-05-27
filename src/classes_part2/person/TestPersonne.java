package classes_part2.person;

public class TestPersonne {
    public static void main(String[] args) {
        Personne personne = new Personne("Dupont", "Jean", 30);
        personne.sePresenter();
        
        // Test des getters
        System.out.println("Nom: " + personne.getNom());
        System.out.println("Prénom: " + personne.getPrenom());
        System.out.println("Âge: " + personne.getAge());
        
        // Test des setters
        personne.setNom("Martin");
        personne.setPrenom("Pierre");
        personne.setAge(25);
        
        // Présentation après modification
        personne.sePresenter();
    }
}
