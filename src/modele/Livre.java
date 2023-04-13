package modele;
import java.sql.SQLException;
import java.util.ArrayList;
import BDD_connexion.Connexion;


public class Livre {
    private int identifiant;
    private String nom;
    private String type;
    private String image;
    private int stock;
    private String auteur;
    private String editeur;
    private String description;
    private double prix;


    public Livre(){}
    public Livre(String N,String T,String I,int S,String A,String E,String D,double P)
    {
        nom=N;
        type=T;
        image=I;
        stock=S;
        auteur=A;
        editeur=E;
        description=D;
        prix=P;
    }

    public int getIdentifiant(){
        return identifiant;
    }
    public void setIdentifiant(int id){
        this.identifiant = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public String getImage(){
        return image;
    }
    public void setImage(String url){
        image = url;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public String getAuteur(){
        return auteur;
    }
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    public String getEditeur(){
        return editeur;
    }
    public void setEditeur(String editeur){
        this.editeur = editeur;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public double getPrix(){
        return prix;
    }
    public void setPrix(double prix){
        this.prix = prix;
    }

    @Override
    public String toString(){
        return (identifiant+"  "+nom+"  "+description+"  "+editeur+"  "+auteur+"  "+type+" en stock : "+stock+" coûtant : "+prix+"\n");
    }

    public boolean recherche_Livre_stock(){
        try{
            Connexion conn = new Connexion("ece_shopping_4","root","");
            String requete = "SELECT * FROM livre WHERE identifiant = '" + identifiant + "';";
            int stock_donnee = 0;
            conn.setRset(conn.getStmt().executeQuery(requete));

            // récupération du résultat de l'ordre
            conn.setRsetMeta(conn.getRset().getMetaData());

            // calcul du nombre de colonnes du resultat
            int nbColonne = conn.getRsetMeta().getColumnCount();
            if(conn.getRset().next()){
                stock_donnee = Integer.parseInt(conn.getRset().getString(8));
                /*if(stock_donnee>=getStock()){
                    int stock_finale = stock_donnee - getStock();
                    requete ="UPDATE livre SET stock = "+stock_finale+" WHERE identifiant = "+getIdentifiant()+";";
                }*/
                conn.close();
                return true;
            }
            else{
                System.out.println("Pas de problème de connexion, mais le livre n'a pas été trouvé !");
                conn.close();
                return false;
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


}
