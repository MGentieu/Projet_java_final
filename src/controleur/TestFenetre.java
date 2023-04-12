package controleur;
import modele.*;
import vue.*;

import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.*;
import java.awt.Menu;

public class TestFenetre{
    public static void main(String[] args) {

        //new Login();

        MaFenetre Accueil = new MaFenetre();
        Accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Accueil.setResizable(false);

    }
}




