package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
            public void actionPerformed(ActionEvent e) {
                // Code pour la connexion
            }
        });
        panel.add(loginButton);

        registerButton = new JButton("Inscription");
        registerButton.setFont(new Font("", Font.PLAIN, 18));
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
