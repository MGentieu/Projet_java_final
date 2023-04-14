package controleur;

import PackagePaiement.Paiement;

import javax.swing.*;
import java.awt.event.*;


public class ValiderPanierAction extends AbstractAction {
    private int M;
    public ValiderPanierAction(String Nom,JPanel pan,int montant)
    {

        super (Nom);
        M=montant;
    }

    public void actionPerformed(ActionEvent e) {
        JFrame pagePaye=new JFrame();
        JPanel P =new JPanel();
        Paiement Paye=new Paiement(getMontant(),P,pagePaye);
        pagePaye.add(P);
        pagePaye.setTitle("CHOIX PAIEMENT");
        pagePaye.setSize(800,300);
        pagePaye.setVisible(true);
        System.out.println("Valider");
    }
    public int getMontant()
    {

        return M;
    }
}
