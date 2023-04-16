package controleur;

import PackagePaiement.Paiement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import vue.Menu.*;
import java.security.PrivateKey;

import static vue.Menu.accueil_page;

public class ValiderPaiementAction extends AbstractAction {
    private JFrame anciennepage=new JFrame();
    private JFrame Pageremerciement=new JFrame();
    public  ValiderPaiementAction(String nom,JFrame fenePaiment)
    {
        super(nom);
        anciennepage=fenePaiment;
    }
    public void actionPerformed(ActionEvent e) {


        ///============= Ouverture d'une oage de remerciement
        getAnciennepage().setVisible(false);
        getPageremerciement().setTitle("REMERCIEMENT");
        getPageremerciement().setSize(800,150);
        String Merci="MERCI D'AVOIR COMMANDE CHEZ NOUS !!! A BIENTOT !!!";
        JLabel label1 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Merci.replaceAll("\n", "<br/>") + "</div></html>");
        label1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);



        getPageremerciement().setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        getPageremerciement().add(label1);
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