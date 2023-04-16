package BDD_connexion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import modele.Livre;
import modele.Utilisateurs;


/**
 *
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 *
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        String urlDatabase = "jdbc:mysql://localhost:3306/"+ nameDatabase;
        //création d'une connexion JDBC à la base
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }

    public  Statement getStmt(){
        return stmt;
    }
    public ResultSet getRset(){return rset;}
    public void setRset(ResultSet rset){
        this.rset = rset;
    }
    public ResultSetMetaData getRsetMeta(){
        return rsetMeta;
    }
    public void setRsetMeta(ResultSetMetaData rsetMeta){
        this.rsetMeta = rsetMeta;
    }


    /**
     * Méthode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     */
    public void ajouterTable(String table) {
        tables.add(table);
    }

    /**
     * Méthode qui ajoute la requete de selection en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * Méthode qui ajoute la requete de MAJ en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * Méthode qui retourne l'ArrayList des champs de la table en parametre
     *
     * @param table
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("select * from " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();
        String champs = "";
        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
        }

        // ajouter un "\n" à la ligne des champs
        champs = champs + "\n";

        // ajouter les champs de la ligne dans l'ArrayList
        liste.add(champs);

        // Retourner l'ArrayList
        return liste;
    }


    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
    public boolean recherche_Livre(Livre l) throws SQLException {
        // récupération de l'ordre de la requete
        String requete = "SELECT * FROM livre WHERE identifiant = '" + l.getIdentifiant() + "';";
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        if (rset.next()) {

            return true;
        } else {
            System.out.println("Livre pas trouvé ! ");
            return false;
        }
    }

    public void executeUpdate_stock(Livre l){

        String requete = "UPDATE livre SET stock WHERE identifiant = "+l.getIdentifiant()+";";

    }
    public void close() {
        try {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList remplirChampsRequete_livres(String requete, String type) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<Livre> liste;
        liste = new ArrayList<Livre>();

        // tant qu'il reste une ligne
        while (rset.next()) {
            Livre l = new Livre();
            liste.add(l);
            l.setIdentifiant(Integer.parseInt(rset.getString(1)));
            l.setNom(rset.getString(2));
            l.setDescription(rset.getString(3));
            l.setEditeur(rset.getString(5));
            l.setAuteur(rset.getString(6));
            l.setType(type);
            l.setStock(Integer.parseInt(rset.getString(8)));
            l.setPrix(Double.parseDouble(rset.getString(9)));

        }

        // Retourner l'ArrayList
        return liste;
    }

    public ArrayList recherche_par_categorie(String categorie) throws SQLException{
        String requete = "SELECT * FROM livre WHERE categorie = '"+categorie+"';";
        return remplirChampsRequete_livres(requete, categorie);
    }
    public ArrayList remplirChampsRequete_clients(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<Utilisateurs> liste;
        liste = new ArrayList<Utilisateurs>();

        // tant qu'il reste une ligne
        while (rset.next()) {
            Utilisateurs u = new Utilisateurs();
            liste.add(u);
            u.setNom(rset.getString(2));
            u.setPrenom(rset.getString(3));
            u.setAge(Integer.parseInt(rset.getString(4)));
            u.setDateNaiss((rset.getString(5)));
            u.setEmail(rset.getString(6));
            u.setMotDePasse(rset.getString(7));
        }

        // Retourner l'ArrayList
        return liste;
    }

    public Livre recher_identifiant(int id) throws SQLException{
        String requete = "SELECT * FROM livre WHERE identifiant = '" + id + "';";
        int stock_donnee = 0;
        Livre l = new Livre();
        rset =stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta=rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        if(rset.next()) {
            l.setIdentifiant(Integer.parseInt(rset.getString(1)));
            l.setNom(rset.getString(2));
            l.setDescription(rset.getString(3));
            l.setEditeur(rset.getString(5));
            l.setAuteur(rset.getString(6));
            l.setType(rset.getString(7));
            l.setStock(Integer.parseInt(rset.getString(8)));
            l.setPrix(Double.parseDouble(rset.getString(9)));
        }
        return l;
    }

    public Utilisateurs recherche_login(String email, String mdp) throws SQLException{
        Utilisateurs u = new Utilisateurs();
        String requete = "SELECT * FROM client WHERE (email = '"+email+"' AND mot_de_passe = '"+mdp+"');";
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        if(rset.next()){
            u.setID(Integer.parseInt(rset.getString(1)));
            u.setNom(rset.getString(2));
            u.setPrenom(rset.getString(3));
            u.setAge(Integer.parseInt(rset.getString(4)));
            u.setDateNaiss((rset.getString(5)));
            u.setEmail(email);
            u.setMotDePasse(mdp);
            u.setAdmin(false);
            return u;
        }
        else{
            requete = "SELECT * FROM employee WHERE email = '"+email+"' AND mot_de_passe = '"+mdp+"';";
            rset = stmt.executeQuery(requete);

            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            nbColonne = rsetMeta.getColumnCount();
            if(rset.next()){
                u = new Utilisateurs();
                u.setID(Integer.parseInt(rset.getString(1)));
                u.setNom(rset.getString(2));
                u.setPrenom(rset.getString(3));
                u.setAge(Integer.parseInt(rset.getString(4)));
                u.setDateNaiss((rset.getString(5)));
                u.setEmail(email);
                u.setMotDePasse(mdp);
                u.setAdmin(true);
                return u;
            }
            else{
                return null;
            }
        }



    }
    public void ajouterPanier(Utilisateurs u, Livre l, int nb_achat) throws SQLException{
        if(nb_achat<=0||nb_achat>l.getStock()){
            System.out.println("On ne peut pas acheter un nombre négatif de livres !");
        }
        else {
            int stk = l.getStock();
            boolean verif_panier = false;
            String requete = "SELECT * FROM panier where id_client = " + u.getID() + ";";
            rset = stmt.executeQuery(requete);
            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            int nbColonne = rsetMeta.getColumnCount();
            boolean verif = false;
            while (rset.next()){
                if(l.getIdentifiant()==Integer.parseInt(rset.getString(2))){
                    verif = true;
                    int q = Integer.parseInt(rset.getString(3))+nb_achat;
                    if(l.getStock()>=q){
                        requete = "UPDATE `panier` SET `quantite` = "+q+" WHERE (panier.id_client = "+u.getID()+" AND panier.id_livre = "+l.getIdentifiant()+");";
                        stmt.executeUpdate(requete);
                        //UPDATE `panier` SET `quantite` = 2 WHERE (panier.id_client = 2 AND panier.id_livre = 2);
                    }
                    break;
                }
            }
            if(!verif){
                requete = "INSERT INTO `panier` (`identifiant`, `id_livre`, `quantite`, `id_client`) VALUES (NULL, '"+l.getIdentifiant()+"', '"+nb_achat+"', '"+u.getID()+"');";
                stmt.executeUpdate(requete);
            }
        }
    }

    public void soustrairePanier(Utilisateurs u, Livre l, int nb_sous) throws SQLException{
        if(nb_sous<=0){
            System.out.println("Pas de soustraction par un nb_négatif !");
        }
        else {
            String requete = "SELECT * FROM panier where id_client = " + u.getID() + ";";
            rset = stmt.executeQuery(requete);
            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();
            int nbColonne = rsetMeta.getColumnCount();
            while (rset.next()){
                if(l.getIdentifiant()==Integer.parseInt(rset.getString(2))){
                    //verif = true;

                    int q = Integer.parseInt(rset.getString(3))-nb_sous;
                    if(q>=1){
                        requete = "UPDATE `panier` SET `quantite` = "+q+" WHERE (panier.id_client = "+u.getID()+" AND panier.id_livre = "+l.getIdentifiant()+");";
                        stmt.executeUpdate(requete);
                        //UPDATE `panier` SET `quantite` = 2 WHERE (panier.id_client = 2 AND panier.id_livre = 2);
                    }
                    else{
                        requete = "DELETE FROM `panier` WHERE (`panier`.`id_client` = "+u.getID()+" AND `panier`.`id_livre` = "+l.getIdentifiant()+");";
                        stmt.executeUpdate(requete);
                        //DELETE FROM `panier` WHERE `panier`.`identifiant` = 44
                    }
                    break;
                }
            }
        }
    }

    public void viderPanier(Utilisateurs u) throws SQLException{
        String requete = "DELETE FROM panier where id_client = " + u.getID() + ";";
        stmt.executeUpdate(requete);
    }

    public void validerOperation(Utilisateurs u) throws SQLException{
        String requete = "SELECT * FROM panier where id_client = " + u.getID() + ";";
        rset = stmt.executeQuery(requete);
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        int nbColonne = rsetMeta.getColumnCount();
        System.out.println("Validation Opération");
        while (rset.next()){
            int id_l = Integer.parseInt(rset.getString(2));
            int q = Integer.parseInt(rset.getString(3));
            requete = "INSERT INTO `historique` (`identifiant`, `id_livre`, `id_client`, `quantite`) VALUES (NULL, "+id_l+","+u.getID()+","+q+");";
            stmt.executeUpdate(requete);
            //INSERT INTO `historique` (`identifiant`, `id_livre`, `id_client`, `quantite`) VALUES (NULL, '1', '2', '2');
        }
    }

    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne
        while (rset.next()) {
            String s = new String();
            for(int i=1;i<=nbColonne;i++){
                s=s+rset.getString(i)+"   ";
            }
            System.out.println(s);
            liste.add(s);
        }

        // Retourner l'ArrayList
        return liste;
    }

    public void recherchePanier(Utilisateurs u)throws SQLException{
        String requete = "SELECT * FROM panier where id_client = " + u.getID() + ";";
        rset = stmt.executeQuery(requete);
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        int nbColonne = rsetMeta.getColumnCount();
        System.out.println("Récupération du panier existant ! ");
        while(rset.next()){
            Livre l1 = new Livre(Integer.parseInt(rset.getString(2)));
            int quantite = Integer.parseInt(rset.getString(3));
            u.getMonPanier().add(l1);
            u.getL_nb_achats().add(quantite);
            u.getVeritable_Panier().AjoutArticle(l1,quantite);
        }
    }
}

