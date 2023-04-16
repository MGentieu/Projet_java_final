package controleur;

import PackagePaiement.CarteBleu;
import PackagePaiement.Paypal;
import vue.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
public class DeconnexionAction extends AbstractAction {

    JFrame frame;
    public DeconnexionAction(String nom,JFrame frame)
    {
        super(nom);
        this.frame=frame;
    }

    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        Login log = new Login();
    }
}