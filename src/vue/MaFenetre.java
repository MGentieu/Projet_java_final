package vue;
import modele.ModeleFenetre;
import modele.Utilisateurs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MaFenetre extends JFrame implements ActionListener
{
    private ArrayList<JButton> tab; // Tableau dynamique permettant de stocker les différents boutons.



    public MaFenetre (Utilisateurs u) {
        
        setSize (1550,1000);
        setTitle ("BookLand");
        new Menu(this,u);
        // acceuil
        JPanel labelTitre = Menu.accueil_page(this,u);
        getContentPane().removeAll();
        getContentPane().add(labelTitre);
        getContentPane().revalidate();
        getContentPane().repaint();
        setVisible(true);
    }
    /**
     * Second constructeur avec les dimensions et le titre en paramètre
     */
    public MaFenetre(ModeleFenetre F2) {
        setSize(F2.getWidth(), F2.getHeight());
        setTitle(F2.getTitle());
        Container contentPane = getContentPane();
        JButton clic = new JButton("clic"); // instancier un bouton nommé clic
        tab = new ArrayList<JButton>();
        tab.add(clic);
        clic.addActionListener(this);
        contentPane.add(clic);
        contentPane.setLayout(new FlowLayout());
        setVisible(true);
    }

    public void ajouterbouton(String nom_bouton){

        JButton bouton = new JButton(nom_bouton);
        bouton.addActionListener(this);
        tab.add(bouton);
        this.getContentPane().add(bouton);
        this.invalidate();
        this.validate();
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent ev){
        /*for(int i=0;i<tab.size();i++){
            if(ev.getSource()==tab.get(i)){
                System.out.println("Vous appuyez sur le bouton numéro "+tab.get(i).getText()+"\n");
                break;
            }
        }*/
    }

}
