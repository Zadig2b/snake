package classes_part3.Animaux;

public class TestAnimaux {

    public static void main(String[] args) {
Animal[] animaux = { new Chien("Shadow"), new Chat("Pomponette") };
for (Animal a : animaux) {
a.crier(); // Appelle la bonne méthode selon l'objet réel
a.comportement();
    
}}}
