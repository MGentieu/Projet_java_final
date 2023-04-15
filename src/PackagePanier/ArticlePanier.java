package PackagePanier;

import modele.Livre;

public class ArticlePanier {
    private int id;
    public String nom;
    public int stock;
    public  double prix;
    public  String imageArt;

    public ArticlePanier(Livre article, int nb_achat)
    {
        id=article.getIdentifiant();
        nom= article.getNom();
        prix= article.getPrix();
        imageArt=article.getImage();
        stock=nb_achat;
    }
    public int getId(){
        return id;
    }
    public double getPrix(){
        return prix;
    }
}
