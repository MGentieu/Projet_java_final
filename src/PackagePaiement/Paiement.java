package PackagePaiement;

import controleur.ChoixPaiementAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paiement  {

    private int PrixPanier;
    private JRadioButton Paypal ;
    private JRadioButton CarteBancaire ;
    private JRadioButton VISA;
    private JPanel Fond=new JPanel(new GridLayout(3,1));
    public Paiement (int montant,JPanel FenPaiement,JFrame frame)
    {
        JPanel AfficheMont=new JPanel();
        PrixPanier=montant;
        JLabel Prix=new JLabel("Montant : "+getTotaPanier());
        Prix.setFont(new Font("Serif", Font.BOLD, 20));
        Prix.setHorizontalTextPosition(JLabel.CENTER);
        //AfficheMont.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
        AfficheMont.add(Prix);

        JPanel ChoixPaiement =new JPanel(new GridLayout(4, 1));
        JLabel ChoixPai=new JLabel(" Choisissez le type de Paiment: ");
        Paypal = new JRadioButton(new ChoixPaiementAction("Paypal",frame));
        CarteBancaire = new JRadioButton(new ChoixPaiementAction("CB",frame));
        VISA = new JRadioButton(new ChoixPaiementAction("VISA",frame));
        CarteBancaire.setText("CB");
        Paypal.setText("PAYPAL");
        VISA.setText("VISA");
        ButtonGroup Paiem=new ButtonGroup();
        //GROUPE DE BOUTON
        Paiem.add(Paypal);
        Paiem.add(CarteBancaire);
        Paiem.add(VISA);
        ChoixPaiement.add(ChoixPai);
        ChoixPaiement.add(Paypal);
        ChoixPaiement.add(CarteBancaire);
        ChoixPaiement.add(VISA);

        Fond.add(AfficheMont);
        Fond.add(ChoixPaiement);
        //Fond.add(donnee);
        FenPaiement.add(Fond);

    }
    public int getTotaPanier()
    {
        return PrixPanier;
    }
}
