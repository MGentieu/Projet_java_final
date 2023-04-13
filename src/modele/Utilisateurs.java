package modele;

import modele.Livre;

import java.util.ArrayList;

public class Utilisateurs {
    protected int ID;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String dateNaiss;
    protected int age;
    protected int role;
    protected ArrayList<Livre> monPanier;
    protected String motDePasse;
    protected boolean isAdmin = false;

    public Utilisateurs(){
        this.monPanier = new ArrayList<Livre>();
    }
    public Utilisateurs(int ID, String nom, String prenom, String email, String dateNaiss, int age, int role,String motDePasse, boolean isAdmin) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaiss = dateNaiss;
        this.age = age;
        this.role = role;
        this.monPanier = new ArrayList<Livre>();
        this.motDePasse = motDePasse;
        this.isAdmin = isAdmin;
    }

    public static Utilisateurs get_info_user_bdd(String email, String motDePasse) {
       // aller chercher dans la bdd le user avec email et mdp donné
        //return Utilisateurs(....)
        return null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public ArrayList<Livre> getMonPanier() {
        return monPanier;
    }

    public void setMonPanier(ArrayList<Livre> monPanier) {
        this.monPanier = monPanier;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {

        return (prenom + " " + nom + ". Âge : " + age + " ans. Date de naissance : " + dateNaiss + ".\nemail : " + email + ". Mot de passe : " + motDePasse);

    }

    public void ajouterPanier(Livre l){
        if(l.getStock()<=0){
            System.out.println("Le livre n'est plus en stock !");
        }
        else{
            monPanier.add(l);
        }
    }

    public void viderPanier(){
        monPanier.clear();
    }

}
