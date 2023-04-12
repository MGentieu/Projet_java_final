package controleur;

import javax.swing.*;
import java.awt.event.*;
public class MoinsAction extends AbstractAction {

    public MoinsAction(String Nom)
    {
        super (Nom);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("-----");
    }
}
