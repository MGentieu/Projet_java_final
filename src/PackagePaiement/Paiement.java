package PackagePaiement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paiement implements ActionListener {

    public int PrixPanier;


    JRadioButton Paypal = new JRadioButton(" Paypal");
    JRadioButton CarteBancaire = new JRadioButton(" Carte Bancaire");
    JRadioButton VISA = new JRadioButton(" VISA ");
    JPanel Fond=new JPanel(new GridLayout(3,1));
    public Paiement (int montant,JPanel FenPaiement)
    {
        JPanel AfficheMont=new JPanel();
        PrixPanier=montant;
        JLabel Prix=new JLabel("Montant : "+PrixPanier);
        Prix.setFont(new Font("Serif", Font.BOLD, 20));
        Prix.setHorizontalTextPosition(JLabel.CENTER);
        //AfficheMont.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
        AfficheMont.add(Prix);

        JPanel ChoixPaiement =new JPanel(new GridLayout(4, 1));
        JLabel ChoixPai=new JLabel(" Choisissez le type de Paiment: ");
        CarteBancaire.setText("CB");
        Paypal.setText("PAYPAL");
        VISA.setText("VISA");
        ButtonGroup Paiem=new ButtonGroup();
        //GROUPE DE BOUTON
        Paiem.add(Paypal);
        Paiem.add(CarteBancaire);
        Paiem.add(VISA);
        Paypal.addActionListener(this);
        CarteBancaire.addActionListener(this);
        VISA.addActionListener(this);
        ChoixPaiement.add(ChoixPai);
        ChoixPaiement.add(Paypal);
        ChoixPaiement.add(CarteBancaire);
        ChoixPaiement.add(VISA);

        Fond.add(AfficheMont);
        Fond.add(ChoixPaiement);
        //Fond.add(donnee);
        FenPaiement.add(Fond);

    }
    public void actionPerformed(ActionEvent ev) {

        if (Paypal.isSelected() ) {
            System.out.println(Paypal.getText());
        }
        if (CarteBancaire.isSelected() ) {
            JFrame CB =new JFrame();

            CarteBleu carteB=new CarteBleu(CB);

        }
        if (VISA.isSelected() ) {
            System.out.println(VISA.getText());
        }
    }

}
