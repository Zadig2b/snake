package classes_part2.bank_account;

public class CompteBancaire {
    private double solde;

    public CompteBancaire(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public void deposer(double montant) {
    
        if (montant > 0) {
            solde += montant;
        } else {
            System.out.println("Le montant à déposer doit être positif.");
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
        } else if (montant > solde) {
            System.out.println("Fonds insuffisants pour le retrait.");
        } else {
            System.out.println("Le montant à retirer doit être positif.");
        }
    }

    public double getSolde() {
        return solde;
    }
}