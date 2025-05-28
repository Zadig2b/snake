import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ETLClientImporter {
    public static void main(String[] args) throws SQLException {
        // Afficher Fenêtre de sélection du fichier CSV
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue != JFileChooser.APPROVE_OPTION) {
            System.out.println("Aucun fichier sélectionné.");
            return;
        }
        File csvFile = fileChooser.getSelectedFile();

        // Paramètres pour la connexion à la base de données
        String url = "jdbc:postgresql://localhost:5432/java_sql";
        String user = "postgres";
        String password = "root";

        // Chargement du driver JDBC
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trouvé : " + e);
            return;
        }

        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, user, password);

        try (
                BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Lecture du fichier .CSV et insertion en base
            String line;
            int count = 0; // Compteur pour le nombre de lignes insérées
            String sql = "INSERT INTO clients (nom, prenom, ville, entreprise, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 5) {
                    stmt.setString(1, values[0].trim()); // nom
                    stmt.setString(2, values[1].trim()); // prenom
                    stmt.setString(3, values[2].trim()); // ville
                    stmt.setString(4, values[3].trim()); // entreprise
                    stmt.setString(5, values[4].trim()); // email
                    stmt.addBatch();
                    count++;
                }
            }

            stmt.executeBatch();
            stmt.close();
            conn.close();
            System.out.println("Nombre de lignes insérées : " + count);

            System.out.println("Importation terminée.");
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }
}