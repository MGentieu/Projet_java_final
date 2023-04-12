package PackageLivre;

import modele.Livre;

import javax.swing.*;

public class DescriptionLivres {
    public String texteLivre;
    public String auteurLivre;
    public String editeurLivre;
    public  String NomLivre;
    public  int stockLivre;
    public DescriptionLivres(Livre monLivre){
        texteLivre=monLivre.description;
        auteurLivre=monLivre.auteur;
        editeurLivre=monLivre.editeur;
        NomLivre=monLivre.nom;
        stockLivre=monLivre.stock;

        JFrame Pop_Pup=new JFrame();
        JOptionPane.showMessageDialog(Pop_Pup,"NOM:"+NomLivre+"\n\nAuteur: "+auteurLivre+
                "\n\nEditeur: "+editeurLivre+"\n\n Stock: "+stockLivre+"\n\nDescription: "+texteLivre);
    }
}
