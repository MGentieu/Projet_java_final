package controleur;

import PackagePaiement.Paiement;
import jdk.jshell.execution.Util;
import modele.Utilisateurs;

import javax.swing.*;
import java.awt.event.*;


public class ValiderPanierAction extends AbstractAction {
    private int M;
    private Utilisateurs u;
    public Utilisateurs getU(){return u;}
    public ValiderPanierAction(String Nom,JPanel pan,int montant, Utilisateurs u)
    {

        super (Nom);
        M=montant;
        this.u = u;
    }

    public void actionPerformed(ActionEvent e) {
        JFrame pagePaye=new JFrame();
        JPanel P =new JPanel();
        Paiement Paye=new Paiement(getMontant(),P,pagePaye,u);
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
