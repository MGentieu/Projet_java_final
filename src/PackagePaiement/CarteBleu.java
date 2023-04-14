package PackagePaiement;

import controleur.ValiderPaiementAction;

import javax.swing.*;
import java.awt.*;

public class CarteBleu {
    private String numeroCarte;
    private String dateCarte;
    private String NomCarte;
    private String cryptogramme;
    private String montantTotal;
    private JPanel donnee=new JPanel(new GridLayout(4, 2,0,15));

    public CarteBleu(JFrame PagePaiement,String nomType)
    {
        PagePaiement.setSize (500,500 );
        PagePaiement.setTitle ("Paiement");


        JLabel Type=new JLabel(nomType);
        Type.setFont(new Font("Serif", Font.BOLD, 25));
        Type.setHorizontalTextPosition(SwingConstants.CENTER);


        JLabel NumCa=new JLabel("Numero de carte :");
        NumCa.setFont(new Font("Serif", Font.BOLD, 18));
        JTextField SaisiNum=new JTextField();
        donnee.add(NumCa);
        donnee.add(SaisiNum);

        //numeroCarte=SaisiNum.getText();

        JLabel Dcarte=new JLabel("Date de la carte :");
        JTextField SaisiDate=new JTextField(5);
        Dcarte.setFont(new Font("Serif", Font.BOLD, 18));

        donnee.add(Dcarte);
        donnee.add(SaisiDate);
        //dateCarte=SaisiDate.getText();

        JLabel NCarte=new JLabel("Nom de la carte :");
        JTextField SaisiNom=new JTextField(30);
        NCarte.setFont(new Font("Serif", Font.BOLD, 18));
        donnee.add(NCarte);
        donnee.add(SaisiNom);
        //NomCarte=SaisiNom.getText();

        JLabel CryCarte=new JLabel("Cryptogramme :");
        JTextField SaisiCrypto=new JTextField(3);
        CryCarte.setFont(new Font("Serif", Font.BOLD, 18));
        donnee.add(CryCarte);
        donnee.add(SaisiCrypto);
        //cryptogramme=Saisi.getText();

        JPanel ButtonVali=new JPanel();
        JButton Valider=new JButton(new ValiderPaiementAction("VALIDER",PagePaiement));
        ButtonVali.add(Valider);

        JPanel cellule =new JPanel(new GridLayout(3,1));


        cellule.add(Type);
        cellule.add(donnee);
        cellule.add(ButtonVali);
        cellule.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        PagePaiement.add(cellule);
        PagePaiement.setVisible(true);
    }
}
