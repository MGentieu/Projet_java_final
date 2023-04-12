package PackagePanier;

import modele.Livre;

import java.util.ArrayList;

public class PanierClient {
    public ArrayList<ArticlePanier> monpanier;

    public PanierClient(){
        monpanier = new ArrayList<>(); // initialisation de la liste
    }
    public void AjoutArticle( Livre nouvLiv)
    {
        ArticlePanier nouveauArticle=new ArticlePanier(nouvLiv);
        monpanier.add(nouveauArticle);
    }
}
