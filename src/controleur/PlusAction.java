package controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlusAction extends AbstractAction {

    public PlusAction(String Nom)
    {
        super (Nom);
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("+++++");
    }

}


