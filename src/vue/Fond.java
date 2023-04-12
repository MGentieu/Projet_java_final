package vue;
import javax.swing.*;

public class Fond {
    
    Fond(MaFenetre f)
    {
        ImageIcon icon = new ImageIcon("Projet_Java\\Fond.jpg");
        f.add(new JLabel(icon));
        f.pack();
    }
}
