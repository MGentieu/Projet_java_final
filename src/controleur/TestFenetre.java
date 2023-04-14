package controleur;
import modele.*;
import vue.*;
import BDD_connexion.Connexion;

import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.*;
import java.awt.Menu;

public class TestFenetre{
    public static void main(String[] args) {



        //  MESSAGE DE MARTIN :
        // JE N'ARRIVE PAS A ECUPERER LE MOT DE PASSE DANS L'ECRAN DU LOGIN.
        // CELA EST PEUT ETRE DU AU MOT DE PASSE QUI EST DE TYPE "JPASSWORDFIELD" AU LIE DE "JTEXTFIELD".
        //new Login();

        MaFenetre Accueil = new MaFenetre();
        Accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Accueil.setResizable(false);

    }
}




