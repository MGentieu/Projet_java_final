package vue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Accueil extends JPanel {

    public Accueil() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Récupération des dimensions du JPanel
        int width = getWidth();
        int height = getHeight();

        // Définition de la police de caractères
        Font font = new Font("Arial", Font.BOLD, 50);
        g.setFont(font);

        // Obtention des dimensions du texte "BOOKLAND"
        String text = "BOOKLAND";
        int textWidth = g.getFontMetrics().stringWidth(text);
        int textHeight = g.getFontMetrics().getHeight();

        // Calcul des coordonnées du texte pour le centrer
        int x = (width - textWidth) / 2;
        int y = (height + textHeight) / 2;

        // Dessin du texte centré
        g.setColor(Color.BLACK);
        g.drawString(text, x, y);
    }
}