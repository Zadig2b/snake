package exos;

import java.util.Scanner;
// Exercice 4 : Calculatrice
// Objectif : Créer un programme qui prend deux entiers et affiche leur somme, différence, produit et quotient.

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier entier : ");
        int num1 = scanner.nextInt();

        System.out.print("Entrez le deuxième entier : ");
        int num2 = scanner.nextInt();

        scanner.close();

        // Déclaration des variables
        // et calcul des opérations
        int sum = num1 + num2;
        int difference = num1 - num2;
        int product = num1 * num2;
        int quotient = num1 / num2;

        // Affichage des résultats
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
    
}
