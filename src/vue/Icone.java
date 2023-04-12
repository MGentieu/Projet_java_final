package vue;
import javax.swing.*;  
import java.awt.*;  

public class Icone {
    
    Icone(MaFenetre fen, String IMAGE)
    {
      Image icon = Toolkit.getDefaultToolkit().getImage("IMAGE");  
      fen.setIconImage(icon);  
      fen.setLayout(null);    
    }
}
