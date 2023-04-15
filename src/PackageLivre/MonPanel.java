package PackageLivre;
import modele.Livre;
import modele.Utilisateurs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MonPanel extends JPanel implements ActionListener {

    int x=1,y=3;
    int compteur=0;

    private ArrayList<Livre> liste_l;
    ArrayList<JButton> boutonAcheter1 ;
    public ArrayList<JButton> getBoutonAcheter1(){
        return boutonAcheter1;
    }
    ArrayList<JButton> boutonDescription1 ;
    JLabel quantite;

    private Utilisateurs u;

    public Utilisateurs getU(){return u;}


    public MonPanel(ArrayList<Livre> livres, Utilisateurs u)
    {
        liste_l = livres;
        boutonAcheter1 = new ArrayList<JButton>();
        boutonDescription1 = new ArrayList<JButton>();
        this.u = u;
        int taille=liste_l.size();
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
            ImageIcon L1 = new ImageIcon(livres.get(i).getImage());
            // Nom de l'article
            JLabel POL1=new JLabel(L1);
            POL1.setVerticalTextPosition(JLabel.BOTTOM);
            POL1.setHorizontalTextPosition(JLabel.CENTER);
            POL1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            POL1.setText(livres.get(i).getNom());
            POL1.setForeground(Color.BLACK);
            POL1.setBackground(Color.WHITE);
            POL1.setOpaque(true);

            cel.setOpaque(false);
            cel.add(POL1, BorderLayout.CENTER);

            //Bouton acheter
             boutonAcheter1.add( new JButton("Ajouter au Panier"));
             boutonAcheter1.get(i).addActionListener(this/*::actionPerformed*/);
             // Bouton description
             boutonDescription1.add(new JButton("Voir +"));
             // Texte Quantité
             quantite = new JLabel("QUANTITE: "+livres.get(i).getStock());
             quantite.setForeground(Color.BLACK);
             quantite.setBackground(Color.WHITE);
             quantite.setOpaque(true);


            JPanel PB = new JPanel(new GridLayout(6, 1));
            PB.add(boutonAcheter1.get(i));
            PB.add(createTransparentPanel(1));
            PB.add(boutonDescription1.get(i));
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
        for(int i=0;i<liste_l.size();i++){
            if (ev.getSource() == boutonAcheter1.get(i)) {
                System.out.println("AEAEHFNCHV");
                u.ajouterPanier(liste_l.get(i),1);

            }
        }
        for(int j=0;j<u.getMonPanier().size();j++){
            System.out.println(u.getMonPanier().get(j).toString()+"\n"+u.getL_nb_achats().get(j)+"   "
                    +u.getVeritable_Panier().getMonpanier().get(j).getStock());
        }
    }

    private JPanel createTransparentPanel(int height) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setPreferredSize(new java.awt.Dimension(0, height));
        return panel;
    }



}
