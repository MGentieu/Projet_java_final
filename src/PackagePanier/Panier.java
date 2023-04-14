package PackagePanier;

import controleur.MoinsAction;
import controleur.PlusAction;
import controleur.ValiderPanierAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panier  {
    private int taillePanier;
    private JButton Valider ;
    private int TotalPanier;
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
            boutonPlus = new JButton(new PlusAction("+"));
            boutonMoins= new JButton(new MoinsAction("-"));
            boutonDescription1= new JButton("Description");
            JLabel Quant=new JLabel("QUANTITE: "+PanierAfficher.monpanier.get(i).stock);
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
        Valider=new JButton(new ValiderPanierAction("Valider",panelPanier,TotalPanier));
        Valider.setPreferredSize(new Dimension(100, 50));
        MontantTotal.add(Montant);
        MontantTotal.add(Valider);

        panelPanier.add(EspacePanier);
        panelPanier.add(MontantTotal);
    }

}
