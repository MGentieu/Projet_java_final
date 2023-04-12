package PackagePanier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panier implements ActionListener {

    public int taillePanier;
    JButton Valider ;
    public int TotalPanier;
    public int Q=0;
    public Panier(PanierClient PanierAfficher, JPanel panelPanier)
    {
        taillePanier=PanierAfficher.monpanier.size();
        TotalPanier=4569;
        int y=1;
        do {
            taillePanier= taillePanier -(3);
            y++;

        }while (taillePanier>3);
        panelPanier.setLayout(new GridLayout(1,2,200,0));
        JPanel EspacePanier=new JPanel(new GridLayout(y,3));
        for (int i=0;i<PanierAfficher.monpanier.size();i++)
        {
            JPanel cel=new JPanel();
            ImageIcon L1 = new ImageIcon(PanierAfficher.monpanier.get(i).imageArt);
            JLabel POL1=new JLabel(L1);
            POL1.setVerticalTextPosition(JLabel.BOTTOM);
            POL1.setHorizontalTextPosition(JLabel.CENTER);
            POL1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            POL1.setText(PanierAfficher.monpanier.get(i).nom);
            cel.add(POL1, BorderLayout.CENTER);
            //Bouton
            JButton boutonPlus ;
            JButton boutonMoins ;
            JButton boutonDescription1 ;
            boutonPlus = new JButton("+");
            boutonMoins= new JButton("-");
            boutonDescription1= new JButton("Description");
            boutonPlus.addActionListener(this);
            JLabel Quant=new JLabel("QUANTITE: "+Q);
            JLabel Prix=new JLabel("Prix: "+PanierAfficher.monpanier.get(i).prix);

            JPanel PB = new JPanel(new GridLayout(5, 1));
            PB.add(boutonPlus);
            PB.add(boutonMoins);
            PB.add(boutonDescription1);
            PB.add(Quant);
            PB.add(Prix);

            cel.add(PB, BorderLayout.SOUTH);
            //Esapce entre les articles
            cel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ajout de la marge


            EspacePanier.add(cel);
        }

        JPanel MontantTotal=new JPanel(new GridLayout(1,2,15,30));
        JLabel Montant=new JLabel("TOTAL: "+TotalPanier+" €");
        Valider=new JButton("VALIDER");
        Valider.setPreferredSize(new Dimension(100, 50));
        MontantTotal.add(Montant);
        MontantTotal.add(Valider);

        panelPanier.add(EspacePanier);
        panelPanier.add(MontantTotal);
    }
    public void actionPerformed(ActionEvent ev) {

    }
}
