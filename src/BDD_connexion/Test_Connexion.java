package BDD_connexion;

import modele.Livre;
import modele.Utilisateurs;

import java.sql.SQLException;
import java.util.ArrayList;

public class Test_Connexion {
    public static void main(String [] args){

        Utilisateurs u = new Utilisateurs();
        Livre l1 = new Livre(1);
        Livre l2 = new Livre(1);

        System.out.println(l1.toString());
        System.out.println(l2.toString());

        try {
            // Création d'une nouvelle connexion à la base de données
            Connexion connexion = new Connexion("ece_shopping_4", "root", "");
            u = connexion.recherche_login("maxime.ambroise@edu.ece.fr","maxime05");
            u.ajouterPanier(l1,1);
            u.ajouterPanier(l2,2);
            //u.validerPanier();
            String requete = "UPDATE livre SET stock = 3 WHERE identifiant = 1;";
            connexion.executeUpdate(requete);
            requete = "UPDATE livre SET stock = 3 WHERE identifiant = 2;";
            connexion.executeUpdate(requete);
            u.viderPanier();
            System.out.println("\n"+u.getL_nb_achats().size()+"    "+u.getMonPanier().size());
            System.out.println("\n\n"+l1.toString());
            System.out.println(l2.toString());
            // System.out.println(u.toString());
            connexion.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*ArrayList<Livre> liste = new ArrayList<Livre>();

        try {
            // Création d'une nouvelle connexion à la base de données
            Connexion connexion = new Connexion("ece_shopping_4", "root", "");
            String requete = "SELECT * FROM livre WHERE categorie = 'policier';";*/
            /*ArrayList<String> resultats = connexion.remplirChampsRequete(requete);
            // Utilisation de la connexion pour exécuter des requêtes, mettre à jour la base de données, etc.

            System.out.println("Livres policiers : ");
            for(int i =0;i<resultats.size();i++){
                System.out.println(resultats.get(i));
            }
            System.out.println("\n\n");*/

            /*liste = connexion.recherche_par_categorie("Policier");
            for(int i = 0;i<liste.size();i++){
                System.out.println(liste.get(i).toString());
            }
            System.out.println(liste.size()+"\n\n");

            String requete2 = "SELECT * FROM client";
            ArrayList<Utilisateurs> users = connexion.remplirChampsRequete_clients(requete2);
            for(int i = 0;i<users.size();i++){
                System.out.println(users.get(i).toString());
            }

            System.out.println("\n\n");
            Utilisateurs u1 = connexion.recherche_login("martin.gentieu@edu.ece.fr","martin02");
            Utilisateurs u2 = connexion.recherche_login("maxime.ambroise@edu.ece.fr","maxime05");
            if(u2!=null){
                System.out.println(u2.toString()+ ". Il est admin : "+u2.isAdmin());
            }
            if(u1!=null){
                System.out.println(u1.toString()+ ". Il est admin : "+u1.isAdmin());
            }

            System.out.println(u2.getMotDePasse()=="maxime05");
            System.out.println(u2.getMotDePasse()+"\n\n");



            connexion.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(liste.size()>=1){ //ON TESTE LA FONCTION DE RECHERCHE DU STOCK
            System.out.println(liste.get(0).recherche_Livre_stock());

        }*/
    }
}
/*
import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

public class Connexion_controle {

    public static void main(String[] args) {
        try {
            // Chargement du pilote JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Création de la connexion à la base de données avec XAMPP
            String url = "jdbc:mysql://localhost:3306/ece_shopping_3";
            String utilisateur = "root";
            String motDePasse = "";
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Exécution de la requête de sélection pour récupérer les livres policiers
            String requete = "SELECT * FROM livre WHERE categorie = 'policier';";
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(requete);

            // Affichage des résultats
            System.out.println("Livres policiers : ");
            while (resultSet.next()) {
                String titre = resultSet.getString("titre");
                String auteur = resultSet.getString("auteur");
                System.out.println("Titre : " + titre + ", Auteur : " + auteur);
            }

            // Fermeture des ressources
            resultSet.close();
            statement.close();
            connexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
*/

