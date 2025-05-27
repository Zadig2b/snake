package exos;
import java.util.Scanner;

//Exercice 3 : Table de multiplication Objectif : Demander un nombre à l’utilisateur et afficher sa table de multiplication (de 1 à 10). 

public class Multiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Demande à l'utilisateur de saisir un nombre
        System.out.print("Entrez un nombre pour afficher sa table de multiplication : ");
        int nombre = scanner.nextInt();
        
        // Affiche la table de multiplication de ce nombre
        System.out.println("Table de multiplication de " + nombre + " :");
        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + " x " + i + " = " + (nombre * i));
        }
        
        // Ferme le scanner
        scanner.close();
    }
    
}
