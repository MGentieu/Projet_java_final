package PackagePaiement;

import BDD_connexion.Connexion;
import controleur.ValiderPaiementAction;
import modele.Utilisateurs;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Paypal {

    private Utilisateurs u;
    public Utilisateurs getU(){return u;}

    private JPanel donnee=new JPanel(new GridLayout(1, 2,0,15));
    public Paypal(JFrame PagePaiement,String nomType, Utilisateurs u)
    {
        this.u = u;
        //conn.validerOperation(u);
        u.validerPanier();
        u.viderPanier();
        try{
            Connexion conn = new Connexion("ece_shopping","root","");
            //conn.validerOperation(u);
            conn.viderPanier(u);

            conn.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        PagePaiement.setSize (500,500 );
        PagePaiement.setTitle ("Paiement");

        JLabel Type=new JLabel(nomType);
        Type.setFont(new Font("Serif", Font.BOLD, 25));
        Type.setHorizontalTextPosition(SwingConstants.CENTER);

        JLabel NumTel=new JLabel("Numero de telephone");
        NumTel.setFont(new Font("Serif", Font.BOLD, 18));
        JTextField SaisiNum=new JTextField();
        donnee.add(NumTel);
        donnee.add(SaisiNum);
        //numeroCarte=SaisiNum.getText();


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

