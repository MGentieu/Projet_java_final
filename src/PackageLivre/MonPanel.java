package PackageLivre;
import modele.Livre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MonPanel extends JPanel {

    int x=1,y=3;
    int compteur=0;


    JButton boutonAcheter1 ;
    JButton boutonDescription1 ;
    JLabel quantite;


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
            // Nom de l'article
            JLabel POL1=new JLabel(L1);
            POL1.setVerticalTextPosition(JLabel.BOTTOM);
            POL1.setHorizontalTextPosition(JLabel.CENTER);
            POL1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            POL1.setText(livres.get(i).nom);
            POL1.setForeground(Color.BLACK);
            POL1.setBackground(Color.WHITE);
            POL1.setOpaque(true);

            cel.setOpaque(false);
            cel.add(POL1, BorderLayout.CENTER);

            //Bouton acheter
             boutonAcheter1 = new JButton("Ajouter au Panier");
             boutonAcheter1.addActionListener(this::actionPerformed);
             // Bouton description
             boutonDescription1 = new JButton("Voir +");
             // Texte Quantité
             quantite = new JLabel("QUANTITE: "+livres.get(i).stock);
             quantite.setForeground(Color.BLACK);
             quantite.setBackground(Color.WHITE);
             quantite.setOpaque(true);


            JPanel PB = new JPanel(new GridLayout(6, 1));
            PB.add(boutonAcheter1);
            PB.add(createTransparentPanel(1));
            PB.add(boutonDescription1);
            PB.add(createTransparentPanel(1));
            PB.add(quantite, BorderLayout.CENTER);

            PB.add(createTransparentPanel(1));
            PB.setOpaque(false);

            JPanel borderPanel = new JPanel(new BorderLayout());
            borderPanel.setOpaque(false);
            borderPanel.add(PB);
            //borderPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            cel.add(borderPanel);

            //Esapce entre les articles
            cel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ajout de la marge
            this.add(cel);
        }


    }
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == boutonAcheter1) {
            System.out.println("AEAEHFNCHV");
        }
    }

    private JPanel createTransparentPanel(int height) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setPreferredSize(new java.awt.Dimension(0, height));
        return panel;
    }



}
