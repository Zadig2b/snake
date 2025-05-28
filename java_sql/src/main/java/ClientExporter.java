import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ClientExporter {
    public static void main(String[] args) {

        // Chargement des variables d'environnement depuis Dotenv
        Dotenv dotenv = Dotenv.load();
        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String csvFilePath = "data/clients.csv"; // Chemin du fichier CSV de sortie

        try (
                // connexion à la base de données
                Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

                // lecture des données dans un ResultSet
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM clients");) {

            // ecriture des données dans un fichier.csv
            // - Utiliser la fonction escape() ci-dessous au moment d’écrire dans le fichier
            // .csv -
            try (PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath))) {
                // Écrire l'en-tête du fichier CSV
                writer.println("id, nom, prenom, ville, entreprise, email");

                // Écrire les données de chaque client
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String email = rs.getString("email");
                    String ville = rs.getString("ville");
                    String entreprise = rs.getString("entreprise");

                    // Écrire une ligne dans le fichier CSV
                    writer.println(id + "," + escape(nom) + "," + escape(prenom) + "," + escape(email) + ","
                            + escape(ville) + "," + escape(entreprise));
                }
            }

        } catch (Exception e) {
            System.out.println("Erreur :" + e);
        }
    }

    // Pour éviter les problèmes avec les virgules ou guillemets
    private static String escape(String field) {
        if (field == null)
            return "";
        if (field.contains(",") || field.contains("\"")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
}
