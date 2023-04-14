package controleur;

import PackagePaiement.Paiement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.PrivateKey;

public class ValiderPaiementAction extends AbstractAction {
    private JFrame anciennepage=new JFrame();
    private JFrame Pageremerciement=new JFrame();
    public  ValiderPaiementAction(String nom,JFrame fenePaiment)
    {
        super(nom);
        anciennepage=fenePaiment;
    }
    public void actionPerformed(ActionEvent e) {

        //Ici liens avec la base donnee pour vider le panier et mettre à jour l'historique

        getAnciennepage().setVisible(false);
        getPageremerciement().setTitle("REMERCIEMENT");
        getPageremerciement().setSize(800,150);
        JTextField Merci=new JTextField("Merci d'avoir commander chez nous...\n\n" +
                "Votre facture seras envoyé par Mail au:...");
        getPageremerciement().add(Merci);
        getPageremerciement().setBackground(Color.gray);
        getPageremerciement().setVisible(true);
    }
    public JFrame getAnciennepage()
    {
        return anciennepage;
    }
    public JFrame getPageremerciement()
    {
        return Pageremerciement;
    }
}
