package modele;

public class Livre {
    public String nom;
    public String type;
    public String image;
    public int stock;
    public String auteur;
    public String editeur;
    public String descrption;
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
        descrption=D;
        prix=P;
    }

}
