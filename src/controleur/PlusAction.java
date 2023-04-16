package controleur;

import BDD_connexion.Connexion;
import modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class PlusAction extends AbstractAction {
    private Utilisateurs u;
    private Livre l;
    public Utilisateurs getU(){return u;}
    public Livre getL(){return l;}

    public PlusAction(String Nom, Utilisateurs u, Livre l)
    {
        super (Nom);
        this.u = u;
        this.l = l;
    }


    public void actionPerformed(ActionEvent ev) {
        System.out.println("+++++");
        u.ajouterPanier(l,1);
        try{
            Connexion conn = new Connexion("ece_shopping","root","");
            conn.ajouterPanier(u,l,1);
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(int j=0;j<u.getMonPanier().size();j++){
            System.out.println(u.getMonPanier().get(j).toString()+"\n"+u.getL_nb_achats().get(j)+"   "
                    +u.getVeritable_Panier().getMonpanier().get(j).getStock()+"   "+u.getMonPanier().get(j).getIdentifiant());
        }
    }

}


