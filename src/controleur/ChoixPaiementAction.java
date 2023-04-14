package controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PackagePaiement.*;
public class ChoixPaiementAction extends AbstractAction {

    private String choix;
    private JFrame maframe=new JFrame();
    public ChoixPaiementAction(String nom,JFrame frame)
    {
        super(nom);
        choix=nom;
        maframe=frame;

    }

    public void actionPerformed(ActionEvent e) {
        if(getChoix()=="Paypal")
        {
            maframe.setVisible(false);
            JFrame Paypal =new JFrame();
            Paypal paypal=new Paypal(Paypal,"Paypal");
        }
        if(getChoix()=="CB")
        {
            maframe.setVisible(false);
            JFrame CB =new JFrame();
            CarteBleu carteB=new CarteBleu(CB,"Carte Bancaire");
        }
        if(getChoix()=="VISA")
        {
            maframe.setVisible(false);
            JFrame Visa =new JFrame();
            CarteBleu carteB=new CarteBleu(Visa,"VISA");
        }
    }

    public String getChoix()
    {
        return choix;
    }
}
