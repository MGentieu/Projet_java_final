package vue;

import controleur.MessageAEnvoyerAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contact extends JPanel  {
    public JButton boutonRecherche;
    public  JTextField saisieRecher;

    public Contact ()
    {
        JPanel cellule = new JPanel(new GridLayout(5,1,0,0));
        cellule.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        cellule.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Marge interne

        JLabel Titre = new JLabel("Nous contacter :");
        Titre.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

        String Mail= "Par E-Mail: BookLand@edu.ece.fr";
        String Telephone ="Par Téléphone: 01-23-45-69-78";
        String ChatBox ="Sinon envoyez nous un message ici:";

        cellule.setLayout(new BoxLayout(cellule, BoxLayout.Y_AXIS));
        cellule.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label1 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Mail.replaceAll("\n", "<br/>") + "</div></html>");
        label1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel label2 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ Telephone.replaceAll("\n", "<br/>") + "</div></html>");
        label2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel label3 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ ChatBox.replaceAll("\n", "<br/>") + "</div></html>");
        label3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel PanelChatBox = new JPanel(new BorderLayout());
        PanelChatBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Marge interne
        saisieRecher= new JTextField();
        saisieRecher.setPreferredSize(new Dimension(800, 300));
        saisieRecher.setBackground(Color.WHITE);
        PanelChatBox.add(saisieRecher, BorderLayout.CENTER);
        boutonRecherche= new JButton(new MessageAEnvoyerAction("ENVOYER",saisieRecher));
        PanelChatBox.add(boutonRecherche, BorderLayout.SOUTH);
        PanelChatBox.add(saisieRecher, BorderLayout.NORTH);


        cellule.add(Titre);
        cellule.add(label1);
        cellule.add(label2);
        cellule.add(label3);
        cellule.add(PanelChatBox);
        this.add(cellule);
    }



}