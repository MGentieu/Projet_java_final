package vue;
import BDD_connexion.Connexion;
import modele.*;
import controleur.RetourLoginAction;

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

        // création du panel pour les champs de saisie
        JPanel inputPanel = new JPanel(new GridLayout(15, 5, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        inputPanel.setBackground(new Color(255, 255, 255));

        // création des labels et champs de saisie
        JLabel nomLabel = new JLabel("Nom :");
        nomLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField nomField = new JTextField();
        nomField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel prenomLabel = new JLabel("Prénom :");
        prenomLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField prenomField = new JTextField();
        prenomField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel dateNaissanceLabel = new JLabel("Date de naissance :");
        dateNaissanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField dateNaissanceField = new JTextField();
        dateNaissanceField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel ageLabel = new JLabel("Age :");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel motDePasseLabel = new JLabel("Mot de passe :");
        motDePasseLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JPasswordField motDePasseField = new JPasswordField();
        motDePasseField.setFont(new Font("Arial", Font.PLAIN, 18));

        // création du panel pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));

        JButton retourButton = new JButton(new RetourLoginAction("RETOUR", this));
        retourButton.setFont(new Font("Arial", Font.PLAIN, 18));
        retourButton.setBackground(new Color(255, 120, 120));
        retourButton.setForeground(Color.WHITE);


        JButton inscrireButton = new JButton(new RetourLoginAction("S'INSCRIRE", this));
        inscrireButton.setFont(new Font("Arial", Font.PLAIN, 18));
        inscrireButton.setBackground(new Color(120, 255, 120));
        inscrireButton.setForeground(Color.WHITE);
        inscrireButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    // recupération de l'utilisateur correspondant dans la BDD :
                    Connexion conn = new Connexion("ece_shopping","root","");
                    String s1 = nomField.getText();
                    String s2 = prenomField.getText();
                    String s3 = ageField.getText();
                    String s4 = dateNaissanceField.getText();
                    String s5 = emailField.getText();
                    String s6 = new String(motDePasseField.getPassword());
                    System.out.println(s4);
                    String REQUETE = "INSERT INTO `client` (`id`, `nom`, `prenom`, `age`, `DateNaissance`, `email`, `mot_de_passe`) VALUES (NULL, '"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s5+"', '"+s6+"');";
                    conn.executeUpdate(REQUETE);
                    conn.close();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // ajout des labels et champs de saisie au panel
        inputPanel.add(nomLabel);
        inputPanel.add(nomField);
        inputPanel.add(prenomLabel);
        inputPanel.add(prenomField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(dateNaissanceLabel);
        inputPanel.add(dateNaissanceField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(motDePasseLabel);
        inputPanel.add(motDePasseField);

        // ajout des boutons au panel
        buttonPanel.add(retourButton);
        buttonPanel.add(inscrireButton);

        // ajout des panels au frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

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
        loginButton.setBackground(new Color(114, 162, 218));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("", Font.PLAIN, 18));

        panel.add(loginButton);

        registerButton = new JButton("Inscription");
        registerButton.setFont(new Font("", Font.PLAIN, 18));
        registerButton.setBackground(new Color(255, 255, 255));
        registerButton.setForeground(new Color(114, 162, 218));
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
                        setVisible(false);
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
