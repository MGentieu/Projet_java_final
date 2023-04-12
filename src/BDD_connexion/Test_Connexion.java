package BDD_connexion;

import modele.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test_Connexion {
    public static void main(String [] args){
        ArrayList<Livre> liste = new ArrayList<Livre>();
        try {
            // Création d'une nouvelle connexion à la base de données
            Connexion connexion = new Connexion("ece_shopping_3", "root", "");
            String requete = "SELECT * FROM livre WHERE categorie = 'policier';";
            ArrayList<String> resultats = connexion.remplirChampsRequete(requete);
            // Utilisation de la connexion pour exécuter des requêtes, mettre à jour la base de données, etc.

            System.out.println("Livres policiers : ");
            for(int i =0;i<resultats.size();i++){
                System.out.println(resultats.get(i));
            }

            connexion.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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

