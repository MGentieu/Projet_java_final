package modele;

import java.awt.*;
import java.util.Scanner;

public class ModeleFenetre {

    private int largeur;
    private int hauteur;
    private String titre;

    private Color color;

    public ModeleFenetre() {
        largeur = 300;
        hauteur = 150;
        titre = "Ma premiere fenetre";
        color = Color.WHITE;
    }

    public void saisirFen() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez la largeur de la fenetre : ");
        String largeurStr = sc.nextLine();
        System.out.print("Entrez la hauteur de la fenetre : ");
        String hauteurStr = sc.nextLine();
        System.out.print("Entrez le titre de la fenetre : ");
        titre = sc.nextLine();
        try {
            largeur = Integer.parseInt(largeurStr);
            hauteur = Integer.parseInt(hauteurStr);
            if (largeur <= 0 || hauteur <= 0) {
                throw new Exception("Les dimensions doivent être positives !");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Les dimensions doivent être des entiers !");
        }
    }

    public int getWidth() {
        return largeur;
    }

    public int getHeight() {
        return hauteur;
    }

    public String getTitle() {
        return titre;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(int rouge, int vert, int bleu){
        if(rouge < 0 || vert < 0 || bleu < 0 || rouge>255 || vert>255 || bleu>255){
            System.out.println("Erreur de saisie dans les couleurs");
        }
        else{
            this.color = new Color(rouge, vert, bleu);
        }
    }
}
