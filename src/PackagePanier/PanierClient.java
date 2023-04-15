package PackagePanier;

import modele.Livre;

import java.util.ArrayList;

public class PanierClient {
    public ArrayList<ArticlePanier> monpanier;

    public PanierClient(){
        monpanier = new ArrayList<>(); // initialisation de la liste
    }
    public ArrayList<ArticlePanier> getMonpanier(){
        return monpanier;
    }
    public void AjoutArticle( Livre nouvLiv, int nb_achat)
    {
        ArticlePanier nouveauArticle=new ArticlePanier(nouvLiv, nb_achat);
        monpanier.add(nouveauArticle);
    }
    public void clear(){
        monpanier.clear();
    }
}
