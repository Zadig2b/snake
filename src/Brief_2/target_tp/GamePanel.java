
package Brief_2.target_tp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {
    private final Timer timer;
    private final Random random = new Random();

    private double angle;
    private double vitesseInitiale;
    private double vitesseVent;
    private int canonX, canonY;
    private int cibleX, cibleY;
    private double projX, projY;
    private double vx, vy;
    private int score = 0;
    private final List<Point> trajectoire = new ArrayList<>();

    private final JTextField angleField = new JTextField(5);
    private final JTextField vitesseField = new JTextField(5);
    private final JButton tirerButton = new JButton("Tirer");
    private final JButton nouvellePosButton = new JButton("Nouvelle position");
    private final JLabel scoreLabel = new JLabel("Score: 0");

    public GamePanel() {
        setPreferredSize(new Dimension(600, 600));
        setLayout(new FlowLayout());
        add(new JLabel("Angle (0-90):"));
        add(angleField);
        add(new JLabel("Vitesse (10-100):"));
        add(vitesseField);
        add(tirerButton);
        add(nouvellePosButton);
        add(scoreLabel);

        placeCannonAndTarget();

        tirerButton.addActionListener(e -> startShooting());
        nouvellePosButton.addActionListener(e -> {
            placeCannonAndTarget();
            trajectoire.clear();
            repaint();
        });

        timer = new Timer(50, e -> updateProjectile());
    }

    private void placeCannonAndTarget() {
        canonX = random.nextInt(100);
        canonY = 500 + random.nextInt(50);
        cibleX = 500 + random.nextInt(50);
        cibleY = 100 + random.nextInt(400);
        projX = canonX;
        projY = canonY;
        vitesseVent = -5 + random.nextInt(11); // [-5, +5]
    }

    private void startShooting() {
        try {
            angle = Double.parseDouble(angleField.getText());
            vitesseInitiale = Double.parseDouble(vitesseField.getText());
            if (angle < 0 || angle > 90 || vitesseInitiale < 10 || vitesseInitiale > 100) {
                JOptionPane.showMessageDialog(this, "Valeurs incorrectes.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer des nombres valides.");
            return;
        }

        double radians = Math.toRadians(angle);
        vx = Math.cos(radians) * vitesseInitiale / 2;
        vy = -Math.sin(radians) * vitesseInitiale / 2;
        projX = canonX;
        projY = canonY;
        trajectoire.clear();
        timer.start();
    }

    private void updateProjectile() {
        projX += vx;
        vx += vitesseVent / 10.0;
        projY += vy;
        vy += 1; // gravité
        trajectoire.add(new Point((int) projX, (int) projY));

        if (projX > getWidth() || projY > getHeight()) {
            timer.stop();
        } else if (new Rectangle(cibleX, cibleY, 20, 20).contains(projX, projY)) {
            timer.stop();
            score++;
            scoreLabel.setText("Score: " + score);
            placeCannonAndTarget();
            trajectoire.clear();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(canonX, canonY, 20, 20);
        g.setColor(Color.RED);
        g.fillRect(cibleX, cibleY, 20, 20);
        g.setColor(Color.BLACK);
        for (Point p : trajectoire)
            g.fillOval(p.x, p.y, 4, 4);
        g.setColor(Color.MAGENTA);
        g.fillOval((int) projX, (int) projY, 6, 6);
    }
}
