package controleur;
import vue.*;
import modele.*;


import javax.swing.*;
import java.awt.event.*;
public class DescriptionAction extends AbstractAction {

    Livre LivreAficher=new Livre();
    public DescriptionAction(String Nom, Livre monLivre)
    {
        super (Nom);

        //LivreAficher.auteur=monLivre.auteur;
        LivreAficher.description=monLivre.description;
        LivreAficher.auteur=monLivre.auteur;
        LivreAficher.editeur=monLivre.editeur;
        LivreAficher.nom=monLivre.nom;
        LivreAficher.stock=monLivre.stock;


    }

    public void actionPerformed(ActionEvent e) {
        JFrame Pop_Pup=new JFrame();
        JOptionPane.showMessageDialog(Pop_Pup,"NOM:"+LivreAficher.nom+
                "\n\nEditeur: "+LivreAficher.editeur+"\n\n Stock: "+LivreAficher.stock+"\n\nDescription: "+LivreAficher.description);

    }
}
