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
        texteLivre=monLivre.getDescription();
        auteurLivre=monLivre.getAuteur();
        editeurLivre=monLivre.getEditeur();
        NomLivre=monLivre.getNom();
        stockLivre=monLivre.getStock();

        JFrame Pop_Pup=new JFrame();
        JOptionPane.showMessageDialog(Pop_Pup,"NOM:"+NomLivre+"\n\nAuteur: "+auteurLivre+
                "\n\nEditeur: "+editeurLivre+"\n\n Stock: "+stockLivre+"\n\nDescription: "+texteLivre);
    }
}
