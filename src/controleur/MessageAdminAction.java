package controleur;
import BDD_connexion.Connexion;
import vue.Login;
import java.util.ArrayList;
import java.sql.*;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serial;

public class MessageAdminAction extends AbstractAction {

    JPanel panel;
    JFrame frame;
    String background_image;
    public MessageAdminAction(String nom,JFrame frame,String background_image)
    {
        super (nom);
        this.frame=frame;
        this.background_image=background_image;
    }

    public void actionPerformed(ActionEvent e) {
        create_panneau_Message();
    }

    private void create_panneau_Message() {
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


        JLabel Titre = new JLabel("MESSAGES RECUE:");
        Titre.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        ////////////////////////////////////////////////////////////////////////
        try {
            // Création d'une nouvelle connexion à la base de données
            Connexion connexion = new Connexion("ece_shopping", "root", "");
            String requete = "SELECT email,message FROM client WHERE (email = 'maxime.ambroise@edu.ece.fr' AND mot_de_passe = 'maxime05')";
            ArrayList<String> resultats = connexion.remplirChampsRequete(requete);
            int taille=resultats.size();
            JPanel panelAdmin=new JPanel(new GridLayout(taille,2,50,50));
            JLabel label1;
            panelAdmin.add(Titre);
            for(int i =0;i<resultats.size();i++){
                JLabel Affichage=new JLabel("MESSAGE "+(i+1)+" : ");
                label1 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ resultats.get(i).replaceAll("\n", "<br/>") + "</div></html>");
                label1.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
                label1=new JLabel(resultats.get(i));
                label1.setAlignmentX(Component.CENTER_ALIGNMENT);
                panelAdmin.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
                panelAdmin.add(Affichage);
                panelAdmin.add(label1);
                panelAdmin.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

            }
            panelAdmin.setLayout(new BoxLayout(panelAdmin, BoxLayout.Y_AXIS));
            panelAdmin.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));







            panel.add(panelAdmin, BorderLayout.CENTER);

            frame.getContentPane().removeAll();
            frame.getContentPane().add(panel);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
            connexion.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ////////////////////////////////////////////////

    }
}