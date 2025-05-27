package brief_1.exos;

//Objectif : Écrire un programme qui affiche les nombres pairs de 1 à 20. 

public class NombresPaires {
    public static void main(String[] args) {
        // On utilise une boucle for pour parcourir les nombres de 1 à 20
        for (int i = 1; i <= 20; i++) {
            // Si le reste de la division par 2 est 0, c'est un nombre pair
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
