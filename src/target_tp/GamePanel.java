package target_tp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel {
    private final Timer timer;
    private final Random random = new Random();
    private double angle;
    private double vitesseInitiale;
    private double vitesseVent;
    private int canonX;
    private int canonY;
    private int cibleX;
    private int cibleY;
    private int projectileX;
    private int projectileY;
    private int score;
    private List<Point> trajectory;

    public GamePanel() {
        // Initialisation du timer
        timer = new Timer(50, e -> {
            updateProjectile();
            repaint();
        });
        // Initialisation des champs de saisie et des boutons
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        JTextField angleField = new JTextField();
        JTextField vitesseField = new JTextField();
        JButton startButton = new JButton("Démarrer");
        JButton stopButton = new JButton("Arrêter");
        JButton resetButton = new JButton("Réinitialiser");
        inputPanel.add(new JLabel("Angle de tir (en degrés) :"));
        inputPanel.add(angleField);
        inputPanel.add(new JLabel("Vitesse initiale :"));
        inputPanel.add(vitesseField);
        inputPanel.add(startButton);
        inputPanel.add(stopButton);
        add(inputPanel, BorderLayout.NORTH);
        add(resetButton, BorderLayout.SOUTH);
        startButton.addActionListener(e -> {
            angle = Double.parseDouble(angleField.getText());
            vitesseInitiale = Double.parseDouble(vitesseField.getText());
            startShooting();
        });
        stopButton.addActionListener(e -> stopShooting());
        resetButton.addActionListener(e -> resetGame());
        trajectory = new ArrayList<>();
        // Initialisation des attributs
        angle = 0.0;
        vitesseInitiale = 0.0;
        vitesseVent = random.nextDouble() * 10 - 5; // Vent entre -5 et +5

        // Initialisation des positions du canon et de la cible
        placeCannonAndTarget();
        // Initialisation des vitesses initiales du projectile
        updateProjectile();
        // Initialisation du score
        score = 0;
        // Initialisation de la trajectoire

    }

    private void resetGame() {
        // Réinitialise les attributs
        angle = 0.0;
        vitesseInitiale = 0.0;
        vitesseVent = random.nextDouble() * 10 - 5;
        placeCannonAndTarget();
        updateProjectile();
        trajectory.clear();
        repaint();
    }

    private void placeCannonAndTarget() {
        // le canon doit etre positionné à gauche de l'écran et la cible à droite
        canonX = random.nextInt(100) + 50; // Position aléatoire du canon
        canonY = random.nextInt(300) + 50; // Position aléatoire du canon
        cibleX = random.nextInt(100) + 500; // Position aléatoire de la cible
        cibleY = random.nextInt(300) + 50; // Position aléatoire de la cible
        trajectory.clear();
    }

    private void startShooting() {
        // Récupère et vérifie les valeurs saisies par l’utilisateur
        // Calcule les vitesses initiales du projectile
        if (angle < 0 || angle > 90) {
            JOptionPane.showMessageDialog(this, "L'angle doit être entre 0 et 90 degrés.");
            return;
        }
        if (vitesseInitiale <= 0) {
            JOptionPane.showMessageDialog(this, "La vitesse initiale doit être positive.");
            return;
        }
        // Démarre le timer
        timer.start();
    }

    private void stopShooting() {
        // Arrête le timer
        timer.stop();
    }

    private void updateProjectile() {
        // Calcul des nouvelles coordonnées du projectile
        double time = trajectory.size() * 0.05; // Temps écoulé en secondes
        projectileX = (int) (canonX + (vitesseInitiale * Math.cos(Math.toRadians(angle)) + vitesseVent) * time);
        projectileY = (int) (canonY
                - (vitesseInitiale * Math.sin(Math.toRadians(angle)) * time - 0.5 * 9.81 * time * time));

        // Ajout de la position actuelle du projectile à la trajectoire
        trajectory.add(new Point(projectileX, projectileY));

        // Test de collision avec la cible
        if (Math.abs(projectileX - cibleX) < 20 && Math.abs(projectileY - cibleY) < 20) {
            score++;
            JOptionPane.showMessageDialog(this, "Cible touchée ! Score : " + score);
            resetGame();
        }

        // Test de sortie d'écran
        if (projectileY > getHeight() || projectileX > getWidth()) {
            stopShooting();
            JOptionPane.showMessageDialog(this, "Le projectile est sorti de l'écran.");
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessine le fond
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, getWidth(), getHeight());
        // Dessine le canon
        g.setColor(Color.blue);
        g.fillRect(canonX, canonY, 50, 20);
        // Dessine la cible
        g.setColor(Color.red);
        g.fillOval(cibleX, cibleY, 40, 40);
        // Dessine le projectile
        g.setColor(Color.black);
        g.fillOval(projectileX, projectileY, 20, 20);
        // Dessine la trajectoire
        g.setColor(Color.green);
        for (Point p : trajectory) {
            g.fillOval(p.x, p.y, 5, 5);
        }
    }

}
