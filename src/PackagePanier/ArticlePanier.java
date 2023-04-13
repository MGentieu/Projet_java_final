package PackagePanier;

import modele.Livre;

public class ArticlePanier {
    public String nom;
    public int stock;
    public  double prix;
    public  String imageArt;

    public ArticlePanier(Livre article)
    {
        nom= article.getNom();
        prix= article.getPrix();
        imageArt=article.getImage();
        stock++;
    }
}
