package Brief_2.Employe;


public abstract class Employe {
    protected String nom;

    public Employe(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public abstract double calculerSalaire();
}