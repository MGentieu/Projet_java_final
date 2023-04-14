package vue;
import BDD_connexion.Connexion;
import modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login extends JFrame {
    private JLabel emailLabel, passwordLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    public Login() {
        setSize (1550,1000);
        setTitle("Page de connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.create_login();
        setVisible(true);
    }

    private void create_sign_up(){

        getContentPane().removeAll();
        //getContentPane().add(null);
        getContentPane().revalidate();
        getContentPane().repaint();

    }

    private void create_login(){
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);

        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(emailLabel);
        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(emailField);


        passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(passwordLabel);
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(passwordField);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        loginButton = new JButton("Connexion");
        loginButton.setFont(new Font("", Font.PLAIN, 18));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                // Code pour la connexion
                try {
                    // recupération de l'utilisateur correspondant dans la BDD :
                    Connexion conn = new Connexion("ece_shopping","root","");
                    System.out.println(emailField.getText());
                    System.out.println(passwordField.getSelectedText());
                    Utilisateurs u = conn.recherche_login(emailField.getText(),passwordField.getSelectedText());
                    if(u==null){
                        System.out.println("Erreur de login.");
                    }
                    else{
                        System.out.println("Connexion réussie !\n"+u.toString());
                    }
                    conn.close();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        panel.add(loginButton);

        registerButton = new JButton("Inscription");
        registerButton.setFont(new Font("", Font.PLAIN, 18));
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                // Code pour l'inscription
                create_sign_up();
            }
        });
        panel.add(registerButton);
        panel.setFont(new Font("Arial", Font.BOLD, 18));


        setLayout(boxLayout);
        add(Box.createVerticalGlue());
        add(panel);
        add(Box.createVerticalGlue());
    }

}
