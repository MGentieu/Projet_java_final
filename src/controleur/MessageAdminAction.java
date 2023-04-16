package controleur;

import vue.Login;

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
        JPanel panelAdmin=new JPanel(new GridLayout(9,1,50,50));

        JLabel Titre = new JLabel("MESSAGES RECUE:");
        Titre.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        String MessageRecue="AAAAA"; //ICI TU met le message recue

        panelAdmin.setLayout(new BoxLayout(panelAdmin, BoxLayout.Y_AXIS));
        panelAdmin.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel label1 = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ MessageRecue.replaceAll("\n", "<br/>") + "</div></html>");
        label1.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));


        label1.setAlignmentX(Component.CENTER_ALIGNMENT);



        panelAdmin.add(Titre);
        panelAdmin.add(label1);

        panel.add(panelAdmin, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }
}