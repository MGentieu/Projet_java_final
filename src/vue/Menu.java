package vue;
import PackageLivre.MonPanel_2;
import PackagePanier.Panier;
import PackagePanier.PanierClient;
import modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.Serial;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import BDD_connexion.Connexion;


public class Menu implements ActionListener {
    JMenu Categorie, Accueil, Apropos, Panier, Compte ;


    JMenuItem C1, C2, C3, C4, C5, C6;
    JMenuItem A1, A2;
    JMenuItem Ac1;
    JMenuItem P1;
    JMenuItem Co1;
    MaFenetre frame;

    JPanel policier;
    JLabel label_policier;
    JPanel fantasstique;
    JPanel theatrale;
    JPanel romantique;
    JPanel aventure;
    JPanel philosophique;
    JPanel panel;
    JPanel newPanier = new JPanel();
    JPanel compte = new JPanel();
    JPanel Aproposs = new JPanel();
    JPanel Histoire = new JPanel();
    Image backgroundImage;


    Menu(MaFenetre frame) {
        this.frame = frame;

        // Créer la barre de menu
        JMenuBar menubar = new JMenuBar();

        // Créer le menu
        Categorie = new JMenu("Catégories");
        Categorie.setFont(new Font("Serif", Font.BOLD, 30));

        C1 = new JMenuItem("Policier");
        C1.addActionListener(this);
        C1.setFont(new Font("Serif", Font.BOLD, 20));

        C2 = new JMenuItem("Science Fiction");
        C2.addActionListener(this);
        C2.setFont(new Font("Serif", Font.BOLD, 20));

        C3 = new JMenuItem("Romantique");
        C3.addActionListener(this);
        C3.setFont(new Font("Serif", Font.BOLD, 20));

        C4 = new JMenuItem("Théatrale");
        C4.addActionListener(this);
        C4.setFont(new Font("Serif", Font.BOLD, 20));

        C5 = new JMenuItem("Aventure");
        C5.addActionListener(this);
        C5.setFont(new Font("Serif", Font.BOLD, 20));

        C6 = new JMenuItem("Philosophique");
        C6.addActionListener(this);
        C6.setFont(new Font("Serif", Font.BOLD, 20));

        // Ajouter les éléments au menu Catégorie
        Categorie.add(C1);
        Categorie.add(C2);
        Categorie.add(C3);
        Categorie.add(C4);
        Categorie.add(C5);
        Categorie.add(C6);

        Apropos = new JMenu("A propos");
        Apropos.addActionListener(this);
        Apropos.setFont(new Font("Serif", Font.BOLD, 30));
        A1 = new JMenuItem("A propos de nous");
        A1.addActionListener(this);
        A1.setFont(new Font("Serif", Font.BOLD, 20));
        A2 = new JMenuItem("Contact");
        A2.addActionListener(this);
        A2.setFont(new Font("Serif", Font.BOLD, 20));
        Apropos.add(A1);
        Apropos.add(A2);

        Accueil = new JMenu("Accueil");
        Accueil.setFont(new Font("Serif", Font.BOLD, 30));
        Accueil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel labelTitre = accueil_page();
                frame.getContentPane().removeAll();
                frame.getContentPane().add(labelTitre);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        Panier=new JMenu("Panier");
        Panier.setFont(new Font("Serif", Font.BOLD, 30));
        P1 = new JMenuItem("Voir mon panier");
        P1.setFont(new Font("Serif", Font.BOLD, 20));
        P1.addActionListener(this);
        JMenuItem IconePanier=new JMenuItem();
        ImageIcon Icone1 = new ImageIcon("categorie.png");
        IconePanier= Redimenssionner(Icone1);
        Panier.add(P1);

        Compte=new JMenu("Compte");
        Compte.setFont(new Font("Serif", Font.BOLD, 30));
        Co1=new JMenuItem("Mon Compte");
        Co1.setFont(new Font("Serif", Font.BOLD, 20));
        Co1.addActionListener(this);
        Compte.add(Co1);



        //barre de recherche
        JPanel RECHERCHE = new JPanel(new BorderLayout());
        JTextField saisieRecher = new JTextField();
        saisieRecher.setPreferredSize(new Dimension(30, 30));
        saisieRecher.setBackground(Color.lightGray);
        RECHERCHE.add(saisieRecher, BorderLayout.CENTER);
        JButton boutonRecherche = new JButton("Rechercher");
        RECHERCHE.add(boutonRecherche, BorderLayout.WEST);


        //ImageIcon Icone1 = new ImageIcon("Projet_Java\\categorie.png");





        // Ajouter le sous menu au menu principale
        menubar.setBackground(Color.lightGray);
        menubar.add(Accueil);
        menubar.add(Categorie);
        menubar.add(Apropos);
        menubar.add(RECHERCHE);
        menubar.add(IconePanier);
        menubar.add(Panier);
        menubar.add(Compte);
        RECHERCHE.setBackground(Color.lightGray);


        Accueil.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        Categorie.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        Apropos.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        RECHERCHE.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        IconePanier.setBorder(BorderFactory.createEmptyBorder(10,10,10,0));
        Panier.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
        Compte.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        // Ajouter la barre de menu au frame
        frame.setJMenuBar(menubar);
    }

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == C1) {
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping_4","root","");
                /*Livre L1 = new Livre("AAAA", "", "Projet_Java/categorie.png", 6, "JC", "Moi", "AAAAAAAAAAAA", 12.33);
                Livre L2 = new Livre("BBBB", "", "Projet_Java/categorie.png", 3, "AH", "TOI", "AAAAAAAAAAAA", 12.33);
                Livre L3 = new Livre("CCCCC", "", "Projet_Java/categorie.png", 1, "EJ", "LUI", "AAAAAAAAAAAA", 12.33);
                Livre L4 = new Livre("EEEEE", "", "Projet_Java/categorie.png", 7, "HF", "poi", "AAAAAAAAAAAA", 12.33);
                Livre L5 = new Livre("EEEEE", "", "Projet_Java/categorie.png", 7, "HF", "poi", "AAAAAAAAAAAA", 12.33);
                Livre L6 = new Livre("EEEEE", "", "Projet_Java/categorie.png", 7, "HF", "poi", "AAAAAAAAAAAA", 12.33);*/
                ArrayList<Livre> philo = conn.recherche_par_categorie("Policier");
                /*philo.add(L1);
                philo.add(L2);
                philo.add(L3);
                philo.add(L4);
                philo.add(L5);
                philo.add(L6);*/
                this.create_panneau("Projet_Java/policier.jpg", philo);
                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else if (ev.getSource() == C2) {
            // recupération des livre dans la BDD
            Livre L1 =new Livre("AAAA","","Projet_Java/categorie.png",6,"JC","Moi","AAAAAAAAAAAA",12.33);
            Livre L2 =new Livre("BBBB","","Projet_Java/categorie.png",3,"AH","TOI","AAAAAAAAAAAA",12.33);
            Livre L3 =new Livre("CCCCC","","Projet_Java/categorie.png",1,"EJ","LUI","AAAAAAAAAAAA",12.33);
            Livre L4=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L5=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L6=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            ArrayList<Livre> philo=new ArrayList<Livre>();
            philo.add(L1);
            philo.add(L2);
            philo.add(L3);
            philo.add(L4);
            philo.add(L5);
            philo.add(L6);
            this.create_panneau("Projet_Java/fantastique.png", philo);
        }
        else if (ev.getSource() == C3) {
            // recupération des livre dans la BDD
            Livre L1 =new Livre("AAAA","","Projet_Java/categorie.png",6,"JC","Moi","AAAAAAAAAAAA",12.33);
            Livre L2 =new Livre("BBBB","","Projet_Java/categorie.png",3,"AH","TOI","AAAAAAAAAAAA",12.33);
            Livre L3 =new Livre("CCCCC","","Projet_Java/categorie.png",1,"EJ","LUI","AAAAAAAAAAAA",12.33);
            Livre L4=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L5=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L6=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            ArrayList<Livre> philo=new ArrayList<Livre>();
            philo.add(L1);
            philo.add(L2);
            philo.add(L3);
            philo.add(L4);
            philo.add(L5);
            philo.add(L6);
            this.create_panneau("Projet_Java/romantique.png", philo);
        }
        else if (ev.getSource() == C4) {
            // recupération des livre dans la BDD
            Livre L1 =new Livre("AAAA","","Projet_Java/categorie.png",6,"JC","Moi","AAAAAAAAAAAA",12.33);
            Livre L2 =new Livre("BBBB","","Projet_Java/categorie.png",3,"AH","TOI","AAAAAAAAAAAA",12.33);
            Livre L3 =new Livre("CCCCC","","Projet_Java/categorie.png",1,"EJ","LUI","AAAAAAAAAAAA",12.33);
            Livre L4=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L5=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L6=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            ArrayList<Livre> philo=new ArrayList<Livre>();
            philo.add(L1);
            philo.add(L2);
            philo.add(L3);
            philo.add(L4);
            philo.add(L5);
            philo.add(L6);
            this.create_panneau("Projet_Java/theatrale.png", philo);
        }
        else if (ev.getSource() == C5) {
            // recupération des livre dans la BDD
            Livre L1 =new Livre("AAAA","","Projet_Java/categorie.png",6,"JC","Moi","AAAAAAAAAAAA",12.33);
            Livre L2 =new Livre("BBBB","","Projet_Java/categorie.png",3,"AH","TOI","AAAAAAAAAAAA",12.33);
            Livre L3 =new Livre("CCCCC","","Projet_Java/categorie.png",1,"EJ","LUI","AAAAAAAAAAAA",12.33);
            Livre L4=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L5=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L6=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            ArrayList<Livre> philo= new ArrayList<Livre>();
            philo.add(L1);
            philo.add(L2);
            philo.add(L3);
            philo.add(L4);
            philo.add(L5);
            philo.add(L6);
            this.create_panneau("Projet_Java/aventure.jpg", philo);
        }
        else if (ev.getSource() == C6) {
            // recupération des livre dans la BDD
            Livre L1 =new Livre("AAAA","","Projet_Java/categorie.png",6,"JC","Moi","AAAAAAAAAAAA",12.33);
            Livre L2 =new Livre("BBBB","","Projet_Java/categorie.png",3,"AH","TOI","AAAAAAAAAAAA",12.33);
            Livre L3 =new Livre("CCCCC","","Projet_Java/categorie.png",1,"EJ","LUI","AAAAAAAAAAAA",12.33);
            Livre L4=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L5=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            Livre L6=new Livre("EEEEE","","Projet_Java/categorie.png",7,"HF","poi","AAAAAAAAAAAA",12.33);
            ArrayList<Livre> philo=new ArrayList<Livre>();
            philo.add(L1);
            philo.add(L2);
            philo.add(L3);
            philo.add(L4);
            philo.add(L5);
            philo.add(L6);
            this.create_panneau("Projet_Java/philosophique.jpg", philo);
        }
        else if (ev.getSource() == P1 ) {
            Livre L1 =new Livre("AAAA","","Projet_Java\\categorie.png",5,"EJ","LUI","AAAAAAAAAAAA",10.99);
            Livre L2 =new Livre("BBBB","","Projet_Java\\categorie.png",6,"EJ","LUI","AAAAAAAAAAAA",12.99);

            PanierClient monpanier=new PanierClient();
            monpanier.AjoutArticle(L1);
            monpanier.AjoutArticle(L2);
            JPanel panelPanier=new JPanel();
            PackagePanier.Panier p1=new Panier(monpanier,panelPanier);

            newPanier.add(panelPanier);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(newPanier);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
        else if (ev.getSource() == Co1 ) {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(compte);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
        else if (ev.getSource() == A1 ) {
            JPanel AP = new JPanel();
            AP = vue.Apropos.create_page_apropos(AP);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(AP);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }

    public static JLabel accueil_page() {
        JLabel labelTitre = new JLabel("BookLand");
        labelTitre.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        labelTitre.setHorizontalAlignment(JLabel.CENTER);
        return labelTitre;
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

        MonPanel_2 p = new MonPanel_2(livres);
        panel.add(p, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    public JMenuItem Redimenssionner( ImageIcon Icone1)
    {
        Image imageOriginale = Icone1.getImage();
        // Définir les dimensions souhaitées de l'image redimensionnée
        int largeurRedimensionnee = 30;
        int hauteurRedimensionnee = 30;
        // Créer une nouvelle image redimensionnée
        Image imageRedimensionnee = imageOriginale.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
        // Créer un nouveau ImageIcon à partir de l'image redimensionnée
        ImageIcon iconeRedimensionnee = new ImageIcon(imageRedimensionnee);
        // Créer un nouveau JLabel pour afficher l'icône redimensionnée
        JLabel labelRedimensionne = new JLabel(iconeRedimensionnee);
        JMenuItem Panier=new JMenuItem(iconeRedimensionnee);
        return Panier;
    }

}