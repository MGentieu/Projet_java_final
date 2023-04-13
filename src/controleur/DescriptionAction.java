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
        LivreAficher.setDescription(monLivre.getDescription());
        LivreAficher.setAuteur(monLivre.getAuteur());
        LivreAficher.setEditeur(monLivre.getEditeur());
        LivreAficher.setNom(monLivre.getNom());
        LivreAficher.setStock(monLivre.getStock());


    }

    public void actionPerformed(ActionEvent e) {
        JFrame Pop_Pup=new JFrame();
        JOptionPane.showMessageDialog(Pop_Pup,"NOM:"+LivreAficher.getNom()+
                "\n\nEditeur: "+LivreAficher.getEditeur()+"\n\n Stock: "+LivreAficher.getStock()+"\n\nDescription: "+LivreAficher.getDescription());

    }
}
