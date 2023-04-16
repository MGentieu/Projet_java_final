package controleur;

import javax.swing.*;
import java.awt.event.*;
public class MessageAEnvoyerAction  extends AbstractAction{

    private JTextField messageAenvoyer;
    public MessageAEnvoyerAction(String Nom, JTextField messageRECU)
    {
        super (Nom);
        this.messageAenvoyer = messageRECU;

    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("saisieRecher:"+messageAenvoyer.getText());

    }
}