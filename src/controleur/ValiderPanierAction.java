package controleur;

import PackagePaiement.Paiement;

import javax.swing.*;
import java.awt.event.*;


public class ValiderPanierAction extends AbstractAction {
    public int M;
    JPanel P;

    public ValiderPanierAction(String Nom,JPanel pan,int montant)
    {

        super (Nom);
        M=montant;
        P=pan;
    }

    public void actionPerformed(ActionEvent e) {
        Paiement Paye=new Paiement(M,P );
    }
}
