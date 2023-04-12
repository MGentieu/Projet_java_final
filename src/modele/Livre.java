package modele;

public class Livre {
    public String nom;
    public String type;
    public String image;
    public int stock;
    public String auteur;
    public String editeur;
    public String description;
    public  double prix;

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

    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setImage(String url){
        image = url;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    public void setEditeur(String editeur){
        this.editeur = editeur;
    }
    public void setDescrption(String description){
        this.description = description;
    }
    public void setPrix(double prix){
        this.prix = prix;
    }

    @Override
    public String toString(){
        return (nom+"  "+description+"  "+editeur+"  "+auteur+"  "+type+" en stock : "+stock+" coûtant : "+prix+"\n");
    }

}
