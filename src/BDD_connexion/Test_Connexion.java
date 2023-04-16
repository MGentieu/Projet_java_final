package BDD_connexion;

import modele.Livre;
import modele.Utilisateurs;

import java.sql.SQLException;
import java.util.ArrayList;


public class Test_Connexion {
    public static void main(String[] args) {

        Utilisateurs u = new Utilisateurs();
        Livre l1 = new Livre(1);
        Livre l2 = new Livre(2);

        System.out.println(l1.toString());
        System.out.println(l2.toString());

        try {
            // Création d'une nouvelle connexion à la base de données
            Connexion connexion = new Connexion("ece_shopping", "root", "");
            u = connexion.recherche_login("maxime.ambroise@edu.ece.fr", "maxime05");
            u.ajouterPanier(l1, 1);
            u.ajouterPanier(l2, 1);
            //u.validerPanier();
            String requete = "UPDATE livre SET stock = 3 WHERE identifiant = 1;";
            connexion.executeUpdate(requete);
            requete = "UPDATE livre SET stock = 3 WHERE identifiant = 2;";
            connexion.executeUpdate(requete);
            u.viderPanier();
            System.out.println("\n" + u.getL_nb_achats().size() + "    " + u.getMonPanier().size());
            System.out.println("\n\n" + l1.toString());
            System.out.println(l2.toString());
            // System.out.println(u.toString());

            requete = "SELECT * FROM client WHERE id = 1;";
            ArrayList<String> l3 = connexion.remplirChampsRequete(requete);
            System.out.println(l3.size());
            connexion.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

