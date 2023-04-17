package modele;

import PackageLivre.MonPanel;
import controleur.DeconnexionAction;
import controleur.MessageAdminAction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;

public class PageCompte {

    private Utilisateurs u;
    private JPanel panel;
    private JFrame frame;
    private String background_image;
    private JButton H;
    private JButton D;
    private JButton A;
    private JButton S;
    private JButton M;
    public PageCompte(Utilisateurs u,JFrame frame,String background_image) {
        this.u = u;
        this.frame=frame;
        this.background_image=background_image;
        if (u.isAdmin()) {

            create_panneau_Admin(background_image);

        }
        else {
            create_panneau_Client(background_image);
        }
    }

    private void create_panneau_Client(String background_image) {
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

        // Récupération de la taille de la fenêtre
        Dimension size =  frame.getSize();
        // Définition de la taille du JPanel
        panel.setPreferredSize(size);
        JPanel panelClient=new JPanel(new GridLayout(5,1,50,50));

        JLabel Titre = new JLabel("Votre Compte:");
        Titre.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        String Histo= "HISTORIQUE DES COMMANDES";
        String Deco ="DECONNEXION ";

        H=new JButton("ICI");

        D=new JButton(new DeconnexionAction("ICI",frame));


        panelClient.setLayout(new BoxLayout(panelClient, BoxLayout.Y_AXIS));
        panelClient.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel label1 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Histo.replaceAll("\n", "<br/>") + "</div></html>");
        label1.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        JLabel label2 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Deco.replaceAll("\n", "<br/>") + "</div></html>");
        label2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        H.setAlignmentX(Component.CENTER_ALIGNMENT);

        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        D.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelClient.add(Titre);
        panelClient.add(label1);
        panelClient.add(H);
        panelClient.add(label2);
        panelClient.add(D);




        panel.add(panelClient, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    private void create_panneau_Admin(String background_image) {
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

        // Récupération de la taille de la fenêtre
        Dimension size =  frame.getSize();
        // Définition de la taille du JPanel
        panel.setPreferredSize(size);
        JPanel panelAdmin=new JPanel(new GridLayout(9,1,50,50));

        JLabel Titre = new JLabel("Votre Compte:");
        Titre.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        String Mess= "MESSAGE RECUE";
        String Ajout= "AJOUTER DES LIVRES";
        String Supp= "SUPPRIMER DES LIVRES";
        String Deco ="DECONNEXION ";

        A=new JButton("ICI");
        S=new JButton("ICI");
        M=new JButton(new MessageAdminAction("ICI",frame,background_image));
        D=new JButton(new DeconnexionAction("ICI",frame));


        panelAdmin.setLayout(new BoxLayout(panelAdmin, BoxLayout.Y_AXIS));
        panelAdmin.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel label1 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Mess.replaceAll("\n", "<br/>") + "</div></html>");
        label1.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        JLabel label2 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Ajout.replaceAll("\n", "<br/>") + "</div></html>");
        label2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        JLabel label3 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Supp.replaceAll("\n", "<br/>") + "</div></html>");
        label3.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        JLabel label4 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Deco.replaceAll("\n", "<br/>") + "</div></html>");
        label4.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        A.setAlignmentX(Component.CENTER_ALIGNMENT);

        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        M.setAlignmentX(Component.CENTER_ALIGNMENT);

        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        S.setAlignmentX(Component.CENTER_ALIGNMENT);

        label4.setAlignmentX(Component.CENTER_ALIGNMENT);
        D.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelAdmin.add(Titre);
        panelAdmin.add(label1);
        panelAdmin.add(M);
        panelAdmin.add(label2);
        panelAdmin.add(A);
        panelAdmin.add(label3);
        panelAdmin.add(S);
        panelAdmin.add(label4);
        panelAdmin.add(D);




        panel.add(panelAdmin, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }
}
