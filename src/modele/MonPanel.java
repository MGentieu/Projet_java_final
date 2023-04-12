package modele;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MonPanel extends JPanel {

    int x=1,y=3;
    int compteur=0;


    JButton boutonAcheter1 = new JButton("Acheter");
    JButton boutonDescription1 = new JButton("Voir +");


    public MonPanel(ArrayList<Livre> livres)
    {
        int taille=livres.size();
        int y=1;
        do {
            taille= taille -(3);
            y++;

        }while (taille>3);

        this.setLayout(new GridLayout(y,3));
        // Transparent
        this.setOpaque(false);

        for (int i=0;i<livres.size();i++)
        {
            JPanel cel=new JPanel();
            ImageIcon L1 = new ImageIcon(livres.get(i).image);
            JLabel POL1=new JLabel(L1);
            POL1.setVerticalTextPosition(JLabel.BOTTOM);
            POL1.setHorizontalTextPosition(JLabel.CENTER);
            POL1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            POL1.setText(livres.get(i).nom);
            cel.add(POL1, BorderLayout.CENTER);
            //Bouton
            JButton boutonAcheter1 = new JButton("Acheter");
            JButton boutonDescription1 = new JButton("Voir +");
            JPanel PB = new JPanel(new GridLayout(2, 1));
            PB.add(boutonAcheter1);
            PB.add(boutonDescription1);
            cel.add(PB, BorderLayout.SOUTH);
            //Esapce entre les articles
            cel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ajout de la marge
            // Transparent
            cel.setOpaque(false);

            this.add(cel);
        }


    }



}
