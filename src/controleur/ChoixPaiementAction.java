package controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PackagePaiement.*;
import modele.Utilisateurs;

public class ChoixPaiementAction extends AbstractAction {

    private String choix;
    private JFrame maframe=new JFrame();
    private Utilisateurs u;
    public Utilisateurs getU(){return u;}
    public ChoixPaiementAction(String nom,JFrame frame,Utilisateurs u)
    {
        super(nom);
        choix=nom;
        maframe=frame;
        this.u=u;

    }

    public void actionPerformed(ActionEvent e) {
        if(getChoix()=="Paypal")
        {
            maframe.setVisible(false);
            JFrame Paypal =new JFrame();
            Paypal paypal=new Paypal(Paypal,"Paypal",u);
        }
        if(getChoix()=="CB")
        {
            maframe.setVisible(false);
            JFrame CB =new JFrame();
            CarteBleu carteB=new CarteBleu(CB,"Carte Bancaire",u);
        }
        if(getChoix()=="VISA")
        {
            maframe.setVisible(false);
            JFrame Visa =new JFrame();
            CarteBleu carteB=new CarteBleu(Visa,"VISA",u);
        }
    }

    public String getChoix()
    {
        return choix;
    }
}
