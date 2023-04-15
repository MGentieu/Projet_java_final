package modele;

import BDD_connexion.Connexion;
import PackagePanier.PanierClient;
import modele.Livre;
import PackagePanier.Panier;

import java.sql.SQLException;
import java.util.ArrayList;

public class Utilisateurs {
    protected int ID;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String dateNaiss;
    protected int age;
    protected int role;
    protected ArrayList<Livre> monPanier;
    private ArrayList<Integer> l_nb_achats;
    protected String motDePasse;
    protected boolean isAdmin = false;

    private PanierClient veritable_Panier;



    public Utilisateurs(){
        this.monPanier = new ArrayList<Livre>();
        this.l_nb_achats = new ArrayList<Integer>();
        this.veritable_Panier = new PanierClient();
    }
    public Utilisateurs(int id){
        this.monPanier = new ArrayList<Livre>();
        this.l_nb_achats = new ArrayList<Integer>();
        try{
            Connexion conn = new Connexion("ece_shopping","root","");
            String requete = "SELECT * FROM client WHERE id = "+id+";";

            int stock_donnee = 0;
            conn.setRset(conn.getStmt().executeQuery(requete));

            // récupération du résultat de l'ordre
            conn.setRsetMeta(conn.getRset().getMetaData());

            // calcul du nombre de colonnes du resultat
            int nbColonne = conn.getRsetMeta().getColumnCount();
            System.out.println(nbColonne);
            if(conn.getRset().next()){

                this.ID = id;
                setNom(conn.getRset().getString(2));
                setPrenom(conn.getRset().getString(3));
                setAge(Integer.parseInt(conn.getRset().getString(4)));
                setDateNaiss(conn.getRset().getString(5));
                setEmail(conn.getRset().getString(6));
                setMotDePasse(conn.getRset().getString(7));
                setAdmin(false);



            }
            else{
                System.out.println("Pas de problème de connexion, mais l'utilisateur n'a pas été trouvé !");
                conn.close();

            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Utilisateurs(String mail, String mdp){
        this.monPanier = new ArrayList<Livre>();
        this.l_nb_achats = new ArrayList<Integer>();
        this.veritable_Panier = new PanierClient();
        try{
            Connexion conn = new Connexion("ece_shopping","root","");
            String requete = "SELECT * FROM employee WHERE email = '"+mail+"' AND mot_de_passe = '"+mdp+"';";
            int stock_donnee = 0;
            conn.setRset(conn.getStmt().executeQuery(requete));

            // récupération du résultat de l'ordre
            conn.setRsetMeta(conn.getRset().getMetaData());

            // calcul du nombre de colonnes du resultat
            int nbColonne = conn.getRsetMeta().getColumnCount();
            if(conn.getRset().next()){
                if(conn.getRset().next()){
                    this.ID = Integer.parseInt(conn.getRset().getString(1));
                    setNom(conn.getRset().getString(2));
                    setPrenom(conn.getRset().getString(3));
                    setAge(Integer.parseInt(conn.getRset().getString(4)));
                    setDateNaiss(conn.getRset().getString(5));
                    setEmail(mail);
                    setMotDePasse(mdp);
                    setAdmin(false);

                }

            }
            else{
                System.out.println("Pas de problème de connexion, mais le livre n'a pas été trouvé !");
                conn.close();

            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Utilisateurs(int ID, String nom, String prenom, String email, String dateNaiss, int age, int role,String motDePasse, boolean isAdmin) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaiss = dateNaiss;
        this.age = age;
        this.role = role;
        this.monPanier = new ArrayList<Livre>();
        this.l_nb_achats = new ArrayList<Integer>();
        this.veritable_Panier = new PanierClient();
        this.motDePasse = motDePasse;
        this.isAdmin = isAdmin;
    }

    public static Utilisateurs get_info_user_bdd(String email, String motDePasse) {
       // aller chercher dans la bdd le user avec email et mdp donné
        //return Utilisateurs(....)
        return null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public ArrayList<Livre> getMonPanier() {
        return monPanier;
    }

    public void setMonPanier(ArrayList<Livre> monPanier) {
        this.monPanier = monPanier;
    }
    public ArrayList<Integer> getL_nb_achats(){
        return l_nb_achats;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public PanierClient getVeritable_Panier(){
        return veritable_Panier;
    }

    @Override
    public String toString() {

        return (getID()+"   "+prenom + " " + nom + ". Âge : " + age + " ans. Date de naissance : " + dateNaiss + ".\nemail : " + email + ". Mot de passe : " + motDePasse);

    }

    public void ajouterPanier(Livre l,int nb_achat){
        if(nb_achat<=0){
            System.out.println("On ne peut pas acheter un nombre négatif de livres !");
        }
        else{
            int stk = l.getStock();
            boolean verif_panier = false;
            try{
                Connexion conn = new Connexion("ece_shopping","root","");
                /*String requete = "SELECT * FROM panier where id_client = "+getID()+";";
                conn.setRset(conn.getStmt().executeQuery(requete));

                // récupération du résultat de l'ordre
                conn.setRsetMeta(conn.getRset().getMetaData());

                // calcul du nombre de colonnes du resultat
                int nbColonne = conn.getRsetMeta().getColumnCount();
                int i=0;*/
                for(int i=0;i<monPanier.size();i++){
                    if(l.getIdentifiant() == monPanier.get(i).getIdentifiant()){


                        if(stk>=l_nb_achats.get(i)+nb_achat){
                            l_nb_achats.set(i,l_nb_achats.get(i)+nb_achat);
                            veritable_Panier.getMonpanier().get(i).setStock(veritable_Panier.getMonpanier().get(i).getStock()+nb_achat);
                            String requete = "UPDATE `panier` SET `quantite` = '"+l_nb_achats.get(i)+"' WHERE (`panier`.`id_client` = "+getID()+" AND `panier`.`id_livre` = "+l.getIdentifiant()+";";
                            conn.executeUpdate(requete);
                        }
                        verif_panier = true;
                        break;
                    }
                    i++;
                }
                if(!verif_panier){
                    String requete = "INSERT INTO `panier` (`identifiant`, `id_livre`, `quantite`, `id_client`) VALUES (NULL, '"+l.getIdentifiant()+"', '"+nb_achat+"', '"+getID()+"');";
                    conn.executeUpdate(requete);
                    monPanier.add(l);
                    l_nb_achats.add((Integer)nb_achat);
                    veritable_Panier.AjoutArticle(l,nb_achat);
                }
                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


    public void viderPanier(){
        monPanier.clear();
        l_nb_achats.clear();
        veritable_Panier.clear();
    }

    public void validerPanier(){
        try {
            // Création d'une nouvelle connexion à la base de données
            Connexion connexion = new Connexion("ece_shopping", "root", "");
            for(int i=0;i<monPanier.size();i++){
                int stock_final = monPanier.get(i).getStock() - l_nb_achats.get(i);
                String requete = "UPDATE livre SET stock = "+stock_final+" WHERE identifiant = "+monPanier.get(i).getIdentifiant()+";";
                connexion.executeUpdate(requete);
                monPanier.get(i).setStock(stock_final);
            }


            connexion.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void suppr_livre(Livre l){
        for(int i=0;i<monPanier.size();i++){
            if(l.getIdentifiant()==monPanier.get(i).getIdentifiant()){
                monPanier.remove(i);
                l_nb_achats.remove(i);
                veritable_Panier.getMonpanier().remove(i);
            }
        }
    }
    public void soustraire(Livre l, int nb_sous){
        if(nb_sous<=0){
            System.out.println("Pas de soustraction par un nb_négatif !");
        }
        else{
            for(int i=0;i<veritable_Panier.getMonpanier().size();i++){
                if(l.getIdentifiant() == monPanier.get(i).getIdentifiant()){

                    if(l_nb_achats.get(i)-nb_sous>=0){
                        l_nb_achats.set(i,l_nb_achats.get(i)-nb_sous);
                        veritable_Panier.getMonpanier().get(i).setStock(veritable_Panier.getMonpanier().get(i).getStock()-nb_sous);
                    }
                    else{
                        suppr_livre(l);
                    }
                    break;
                }
            }
        }
    }
    public void ajouterPanier2(){
        try{
            Connexion conn = new Connexion("ece_shopping","root","");
            String requete = "SELECT * FROM panier where id_client = "+getID()+";";
            conn.setRset(conn.getStmt().executeQuery(requete));

            // récupération du résultat de l'ordre
            conn.setRsetMeta(conn.getRset().getMetaData());

            // calcul du nombre de colonnes du resultat
            int nbColonne = conn.getRsetMeta().getColumnCount();
            int i=0;
            while(conn.getRset().next()){

                Livre l1 = new Livre(Integer.parseInt(conn.getRset().getString(2)));
                int quantite = Integer.parseInt(conn.getRset().getString(3));
                monPanier.add(l1);
                l_nb_achats.add(quantite);
                veritable_Panier.AjoutArticle(l1,quantite);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void recup_panier(){
        try{
            Connexion connexion = new Connexion("ece_shopping", "root", "");
            String requete = "SELECT * FROM panier WHERE id_client = "+getID()+";";
            connexion.setRset(connexion.getStmt().executeQuery(requete));

            // récupération du résultat de l'ordre
            connexion.setRsetMeta(connexion.getRset().getMetaData());

            // calcul du nombre de colonnes du resultat
            int nbColonne = connexion.getRsetMeta().getColumnCount();
            while(connexion.getRset().next()){
                int id = Integer.parseInt(connexion.getRset().getString(2));
                int nb_achat = Integer.parseInt(connexion.getRset().getString(3));
                Livre l = new Livre(id);
                System.out.println(l.toString());
                //ajouterPanier2();
            }
            connexion.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
