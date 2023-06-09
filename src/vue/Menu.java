package vue;
import PackageLivre.MonPanel;
import PackagePanier.Panier;
import PackagePanier.PanierClient;
import modele.*;
import controleur.OffreAction;

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
    private Utilisateurs u;


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
    JPanel contact = new JPanel();
    JPanel panel;
    JPanel newPanier = new JPanel();
    JPanel compte = new JPanel();
    JPanel Aproposs = new JPanel();
    JPanel Histoire = new JPanel();
    Image backgroundImage;


    Menu(MaFenetre frame, Utilisateurs u) {
        this.frame = frame;
        this.u = u;

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
                JPanel labelTitre = accueil_page(frame,u);
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
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> policiers = conn.recherche_par_categorie("Policier");
                for(int i=0;i<policiers.size();i++){
                    policiers.get(i).setImage("C:\\Users\\33695\\IdeaProjects\\Projet_Java_12_04\\Projet_Java\\categorie.png");
                }
                this.create_panneau("policiers3.jpg", policiers);

                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else if (ev.getSource() == C2) {
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> sciencef = conn.recherche_par_categorie("Science-Fiction");
                for(int i=0;i<sciencef.size();i++){
                    sciencef.get(i).setImage("C:\\Users\\33695\\IdeaProjects\\Projet_Java_12_04\\Projet_Java\\categorie.png");
                }
                this.create_panneau("SF2.jpg", sciencef);

                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (ev.getSource() == C3) {
            // recupération des livre dans la BDD
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> romantiques = conn.recherche_par_categorie("Romantique");
                for(int i=0;i<romantiques.size();i++){
                    romantiques.get(i).setImage("C:\\Users\\33695\\IdeaProjects\\Projet_Java_12_04\\Projet_Java\\categorie.png");
                }
                this.create_panneau("love.jpg", romantiques);

                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (ev.getSource() == C4) {
            // recupération des livre dans la BDD
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> theatrales = conn.recherche_par_categorie("Theatrale");
                for(int i=0;i<theatrales.size();i++){
                    theatrales.get(i).setImage("C:\\Users\\33695\\IdeaProjects\\Projet_Java_12_04\\Projet_Java\\categorie.png");
                }
                this.create_panneau("theatrale2.jpg", theatrales);

                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (ev.getSource() == C5) {
            // recupération des livre dans la BDD
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> aventures = conn.recherche_par_categorie("Aventure");
                for(int i=0;i<aventures.size();i++){
                    aventures.get(i).setImage("C:\\Users\\33695\\IdeaProjects\\Projet_Java_12_04\\Projet_Java\\categorie.png");
                }
                this.create_panneau("aventure2.jpg", aventures);

                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (ev.getSource() == C6) {
            // recupération des livre dans la BDD
            try {
                // recupération des livre dans la BDD
                Connexion conn = new Connexion("ece_shopping","root","");
                ArrayList<Livre> philo = conn.recherche_par_categorie("Philosophique");
                for(int i=0;i<philo.size();i++){
                    philo.get(i).setImage("C:\\Users\\33695\\IdeaProjects\\Projet_Java_12_04\\Projet_Java\\categorie.png");
                }
                this.create_panneau("philo2.jpg", philo);

                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (ev.getSource() == P1 ) {
            //Livre L1 =new Livre("AAAA","","categorie.png",5,"EJ","LUI","AAAAAAAAAAAA",10.99);
            //Livre L2 =new Livre("BBBB","","categorie.png",6,"EJ","LUI","AAAAAAAAAAAA",12.99);

            //PanierClient monpanier=new PanierClient();
            //monpanier.AjoutArticle(L1);
            //monpanier.AjoutArticle(L2);
            /*Livre l1 = new Livre(1);
            u.ajouterPanier(l1,1);
            System.out.println(u.getMonPanier().get(0).toString()+"\n"+u.getL_nb_achats().get(0)+"   "
            +u.getVeritable_Panier().getMonpanier().get(0).getStock());
            u.ajouterPanier(l1,1);
            System.out.println(u.getMonPanier().get(0).toString()+"\n"+u.getL_nb_achats().get(0)+"   "
                    +u.getVeritable_Panier().getMonpanier().get(0).getStock());
            System.out.println(l1.toString());*/
            PackagePanier.Panier p1=new Panier(u,frame,"bibliotheque.jpg");
        }
        else if (ev.getSource() == Co1 ) {
            PageCompte pageCOMPTE=new PageCompte(u,frame,"compte.jpg");
        }
        else if (ev.getSource() == A1 ) {
            JPanel AP = new JPanel();
            AP = vue.Apropos.create_page_apropos(AP);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(AP);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
        else if(ev.getSource() == A2){
            Contact PageContact = new Contact();
            contact.add(PageContact);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(contact);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }

    /*public static JLabel accueil_page() {
        JLabel labelTitre = new JLabel("BookLand");
        labelTitre.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        labelTitre.setHorizontalAlignment(JLabel.CENTER);
        return labelTitre;
    }*/
    public static JPanel accueil_page(JFrame frame, Utilisateurs u1) {
        JPanel PanelAcueil = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);

        JLabel labelTitre = new JLabel("BOOKLAND");
        labelTitre.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        labelTitre.setForeground(new Color(204, 0, 0));
        PanelAcueil.add(labelTitre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(50, 0, 0, 0);
        gbc.anchor = GridBagConstraints.NORTH;

        JPanel Offre = new JPanel(new GridLayout(2, 2, 20, 20));

        JPanel Offre1 = new JPanel(new GridLayout(2, 1));
        JLabel LabelOffre1 = new JLabel("-30% si vous achetez 5 livres dans la catégorie Philosophique");
        LabelOffre1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        JButton Buttonoffre1;
        Buttonoffre1= new JButton(new OffreAction("OFFRE PHILO",PanelAcueil,frame,u1));
        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel1.add(Buttonoffre1);
        Offre1.add(LabelOffre1);
        Offre1.add(buttonPanel1);

        JPanel Offre2 = new JPanel(new GridLayout(2, 1));
        JLabel LabelOffre2 = new JLabel("Pour 2 romans policier achetés, le 3ème est offert !!! ");
        LabelOffre2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        JButton Buttonoffre2 = new JButton(new OffreAction("OFFRE POLICIER",PanelAcueil,frame,u1));

        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel2.add(Buttonoffre2);
        Offre2.add(LabelOffre2);
        Offre2.add(buttonPanel2);

        JPanel Offre3 = new JPanel(new GridLayout(2, 1));
        JLabel LabelOffre3 = new JLabel("-70% pour 6 Livres fantastiques achetés avant le 27 Avril 2023");
        LabelOffre3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        JButton Buttonoffre3 = new JButton(new OffreAction("OFFRE FANTASTIQUE",PanelAcueil,frame,u1));

        JPanel buttonPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel3.add(Buttonoffre3);
        Offre3.add(LabelOffre3);
        Offre3.add(buttonPanel3);

        Offre.add(Offre1);
        Offre.add(Offre2);
        Offre.add(Offre3);

        PanelAcueil.add(Offre, gbc);
        PanelAcueil.setBackground(new Color(255, 255, 204));

        return PanelAcueil;
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