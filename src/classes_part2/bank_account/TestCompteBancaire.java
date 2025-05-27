package classes_part2.bank_account;

public class TestCompteBancaire {
    public static void main(String[] args) {
        // Création d'un compte bancaire avec un solde initial de 1000 euros
        CompteBancaire compte = new CompteBancaire(1000.0);
        
        // Affichage du solde initial
        System.out.println("Solde initial: " + compte.getSolde() + " euros");
        
        // Test du dépôt
        compte.deposer(500.0);
        System.out.println("Solde après dépôt de 500 euros: " + compte.getSolde() + " euros");
        
        // Test du retrait
        compte.retirer(200.0);
        System.out.println("Solde après retrait de 200 euros: " + compte.getSolde() + " euros");
        
        // Test d'un retrait supérieur au solde
        compte.retirer(1500.0);
        
        // Test d'un dépôt négatif
        compte.deposer(-100.0);
        
        // Affichage final du solde
        System.out.println("Solde final: " + compte.getSolde() + " euros");
    }
    
}
