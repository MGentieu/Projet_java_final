package controleur;

import BDD_connexion.Connexion;
import PackageLivre.MonPanel;
import modele.Livre;
import modele.Utilisateurs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.ArrayList;


public class OffreAction extends AbstractAction {

    public JButton MonButton;
    JPanel panel;
    String Choix;
    JFrame frame;
    Utilisateurs u;
    public OffreAction(String nom,JPanel panel,JFrame frame,Utilisateurs u)
    {
        super(nom);
        //this.MonButton=boutonRecu;
        this.panel=panel;
        this.u=u;
        this.frame=frame;
        Choix=nom;
    }

    public void actionPerformed(ActionEvent e) {
        if ( Choix=="OFFRE PHILO")
        {
            // recupération des livre dans la BDD
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> philo = conn.recherche_par_categorie("Philosophique");
                this.create_panneau("Projet_Java/policier.jpg", philo);
                conn.close();
            } catch (SQLException | ClassNotFoundException ev) {
                ev.printStackTrace();
            }
        }
        else if ( Choix=="OFFRE POLICIER")
        {
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> policiers = conn.recherche_par_categorie("Policier");
                this.create_panneau("Projet_Java/policier.jpg", policiers);
                for(int i=0;i<policiers.size();i++){
                    policiers.get(i).setImage("categorie.png");
                }
                conn.close();
            } catch (SQLException | ClassNotFoundException ev) {
                ev.printStackTrace();
            }
        }
        else if ( Choix=="OFFRE FANTASTIQUE")
        {
            // recupération des livre dans la BDD
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> aventures = conn.recherche_par_categorie("Aventure");
                this.create_panneau("Projet_Java/policier.jpg", aventures);
                conn.close();
            } catch (SQLException | ClassNotFoundException ev) {
                ev.printStackTrace();
            }
        }

    }
    private void create_panneau(String background_image, ArrayList<Livre> livres) {
        // Créer un nouveau panneau
        panel = new JPanel() {
            @Serial
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image image;
                    image = ImageIO.read(new File(background_image));
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        JScrollBar scrollPane = new JScrollBar();
        panel.add(scrollPane);
        // Récupération de la taille de la fenêtre
        Dimension size =  frame.getSize();
        // Définition de la taille du JPanel
        panel.setPreferredSize(size);

        MonPanel p = new MonPanel(livres, u);
        panel.add(p, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }
}
