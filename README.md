## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Types: primitifs et d'inférence
maj. et non maj
classe / 

## Opérateurs:
pas de "==="

# Comparaisons de références:

stack / Tas 

comparer une string: utiliser equals (même contenu à 2 endroits de la mémoire différents)
les string sont dans le tas et les int sont dans la stack

# Les tableaux

int tableau_entiers[]

alloc mémoire via new:
tableau_entiers = new int[5]

ou int tableau_entiers[]= new int [5]

# Structures de contrôles:

Conditions / Switch / Boucles

# Flux entrées/sortie: Stream
system.in : clavier
system.out : écran
system.err : écran

java.util.Scanner;

public class App {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in)

        System.out.print("Entrez votre nom:" );
        String nom
    }
}

# Les collections

package.java.util

# L'interface COllection:

Collection <String> mots = new ArrayList<>();
mots.add("Java")
mots.add("Collection")

# les Listes
autorisent les doublons

List<String>
For Ou Iterator<String> (it.hasNext )

# Les Ensembles

Set<String>
n'autorise pas les doublons

# Les dictionnaires

Map<String, Integer> notes = new HashMap<>();

méthodes:
getKey, getValue, keySet

# For VS Itérateurs

itérateur: suppression pendant l'itération possible




