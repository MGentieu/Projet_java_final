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

    private String email;
    private String mot_de_passe;
    private boolean verif_register;

    private Utilisateurs u;
    public Login() {
        setSize (1550,1000);
        setTitle("Page de connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.create_login();
        setVisible(true);
        u = new Utilisateurs();
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getMot_de_passe(){
        return mot_de_passe;
    }
    public void setMot_de_passe(String motDePasse){
        this.mot_de_passe = motDePasse;
    }
    public boolean isVerif_register(){
        return verif_register;
    }
    public Utilisateurs getU(){
        return u;
    }
    public void setU(Utilisateurs u){
        this.u = u;
    }

    private void create_sign_up(){

        getContentPane().removeAll();
        //getContentPane().add(null);
        getContentPane().revalidate();
        getContentPane().repaint();

    }

    public Utilisateurs user(String mail, String mdp){
        return new Utilisateurs(mail,mdp);
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


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                // Code pour la connexion
                try {
                    // recupération de l'utilisateur correspondant dans la BDD :
                    Connexion conn = new Connexion("ece_shopping","root","");
                    String mail = emailField.getText();
                    String mdp = new String(passwordField.getPassword());
                    System.out.println(mail);
                    System.out.println(mdp);
                    u = conn.recherche_login(mail,mdp);
                    System.out.println(u.toString());
                    u.ajouterPanier2();
                    for(int j=0;j<u.getMonPanier().size();j++){
                        System.out.println(u.getMonPanier().get(j).toString()+"\n"+u.getL_nb_achats().get(j)+"   "
                                +u.getVeritable_Panier().getMonpanier().get(j).getStock()+"   "+u.getMonPanier().get(j).getIdentifiant());
                    }
                    if(u.getID()==0){
                        System.out.println("Erreur de login.");
                    }
                    else{
                        System.out.println("Connexion réussie !\n"+u.toString());
                        setVisible(false);
                        MaFenetre Accueil = new MaFenetre(u);
                        Accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        Accueil.setResizable(false);
                    }
                    conn.close();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });





        setLayout(boxLayout);
        add(Box.createVerticalGlue());
        add(panel);
        add(Box.createVerticalGlue());
    }

}
