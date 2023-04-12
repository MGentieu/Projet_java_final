package PackagePaiement;

import javax.swing.*;
import java.awt.*;

public class CarteBleu {
    public String numeroCarte;
    public String dateCarte;
    public String NomCarte;
    public String cryptogramme;
    public String montantTotal;
    JPanel donnee=new JPanel(new GridLayout(4, 2,0,15));

    public CarteBleu(JFrame PagePaiement)
    {
        PagePaiement.setSize (500,500 );
        PagePaiement.setTitle ("Paiement");

        JLabel NumCa=new JLabel("Numero de carte :");
        NumCa.setFont(new Font("Serif", Font.BOLD, 18));
        JTextField SaisiNum=new JTextField();
        NumCa.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        donnee.add(NumCa);
        donnee.add(SaisiNum);
        //numeroCarte=SaisiNum.getText();

        JLabel Dcarte=new JLabel("Date de la carte :");
        JTextField SaisiDate=new JTextField(5);
        Dcarte.setFont(new Font("Serif", Font.BOLD, 18));
        Dcarte.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        donnee.add(Dcarte);
        donnee.add(SaisiDate);
        //dateCarte=SaisiDate.getText();

        JLabel NCarte=new JLabel("Nom de la carte :");
        JTextField SaisiNom=new JTextField(30);
        NCarte.setFont(new Font("Serif", Font.BOLD, 18));
        NCarte.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        donnee.add(NCarte);
        donnee.add(SaisiNom);
        //NomCarte=SaisiNom.getText();

        JLabel CryCarte=new JLabel("Cryptogramme :");
        JTextField SaisiCrypto=new JTextField(3);
        CryCarte.setFont(new Font("Serif", Font.BOLD, 18));
        CryCarte.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        donnee.add(CryCarte);
        donnee.add(SaisiCrypto);
        //cryptogramme=Saisi.getText();

        JPanel ButtonVali=new JPanel();
        JButton Valider=new JButton("VALIDER");
        ButtonVali.add(Valider);


        JPanel cellule =new JPanel(new GridLayout(2,1));


        cellule.add(donnee);
        cellule.add(ButtonVali);
        cellule.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        PagePaiement.add(cellule);
        PagePaiement.setVisible(true);
    }
}
