package controleur;
import BDD_connexion.Connexion;
import vue.Login;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import modele.Utilisateurs;

public class MessageAEnvoyerAction  extends AbstractAction{
    // Utilisateurs u;
    private JTextField messageAenvoyer;
    public MessageAEnvoyerAction(String Nom, JTextField messageRECU)
    {
        super (Nom);
        this.messageAenvoyer = messageRECU;
        //u=u1;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("saisieRecher:"+messageAenvoyer.getText());
        //remplacer par l'envoie dans la base de donnée
        try {
            // Création d'une nouvelle connexion à la base de données
            Connexion connexion = new Connexion("ece_shopping", "root", "");
            String requete = "UPDATE client SET message="+messageAenvoyer.getText()+" WHERE  id = Utilisateurs.getID()";
            connexion.close();
        }
        catch (SQLException | ClassNotFoundException ev) {
            ev.printStackTrace();
        }
    }
}