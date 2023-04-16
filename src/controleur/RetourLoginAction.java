package controleur;
import vue.Login;

import java.awt.event.*;
import javax.swing.*;

public class RetourLoginAction extends AbstractAction {
    JFrame frame;
    public RetourLoginAction(String Nom, JFrame frame) {
        super(Nom);
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        Login log = new Login();
    }
}