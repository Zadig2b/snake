package classes_part3.Employe;

public class Freelance extends Employe {
private int heures;
private double tarifHoraire;
    public Freelance(String nom, int heures, double tarifHoraire) {
        super(nom);
        this.heures = heures;
        this.tarifHoraire = tarifHoraire;
    }

    @Override
    public double calculerSalaire() {
        return heures * tarifHoraire;
    }
    
}
