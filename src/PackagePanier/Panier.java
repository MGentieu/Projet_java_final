package PackagePanier;

import controleur.DeconnexionAction;
import controleur.MoinsAction;
import controleur.PlusAction;
import controleur.ValiderPanierAction;
import modele.Utilisateurs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serial;

public class Panier  {
    private int taillePanier;
    private JButton Valider ;
    private int TotalPanier;
    JPanel panel;

    JFrame frame;
    String background_image;
    Utilisateurs u;
    public Panier(Utilisateurs u,JFrame frame,String background_image)
    {
        this.u = u;
        this.frame=frame;
        this.background_image=background_image;
        create_panneau_Client(background_image);
    }

    private void create_panneau_Client(String background_image) {
        // Créer un nouveau panneau
        panel = new JPanel() {
            @Serial
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image image;
                    image = ImageIO.read(new File(background_image));
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        // Récupération de la taille de la fenêtre
        Dimension size =  frame.getSize();
        // Définition de la taille du JPanel
        panel.setPreferredSize(size);
        JPanel panelClient=new JPanel(new GridLayout(5,1,50,50));

        ///============================================================
        taillePanier=u.getVeritable_Panier().monpanier.size();
        TotalPanier=0;
        int offre_philo=0;
        boolean verif1 = true;

        int offre_policier=0;
        int sum_rabais_police = 0;

        int offre_fanta=0;
        boolean verif2 = true;

        for(int i=0;i<taillePanier;i++){
            int prix=0;
            if(u.getMonPanier().get(i).getType()=="Policier"){
                offre_policier+=u.getL_nb_achats().get(i);
                prix = (int)u.getVeritable_Panier().monpanier.get(i).getPrix()*u.getL_nb_achats().get(i);
            }
            else if(u.getMonPanier().get(i).getType()=="Science-Fiction"){
                offre_fanta+=u.getL_nb_achats().get(i);
                prix = (int)u.getVeritable_Panier().monpanier.get(i).getPrix()*u.getL_nb_achats().get(i);
                if(offre_fanta>=6 && verif2){
                    verif2 = false;
                    prix = (int)(prix*0.3);
                }
            }
            else if(u.getMonPanier().get(i).getType()=="Philosophique"){
                offre_philo+=u.getL_nb_achats().get(i);
                prix = (int)u.getVeritable_Panier().monpanier.get(i).getPrix()*u.getL_nb_achats().get(i);
                if(offre_philo>=5 && verif1){
                    verif1 = false;
                    prix = (int)(prix*0.7);
                }
            }

            TotalPanier = TotalPanier + prix;
        }
        sum_rabais_police = (int)(offre_policier/3);
        TotalPanier = TotalPanier - sum_rabais_police * 9;
        //TotalPanier = 20;
        int y=1;
        do {
            taillePanier= taillePanier -(3);
            y++;

        }while (taillePanier>3);
        panel.setLayout(new GridLayout(1,2,200,0));
        JPanel EspacePanier=new JPanel(new GridLayout(y,3));
        for (int i=0;i<u.getVeritable_Panier().monpanier.size();i++)
        {
            JPanel cel=new JPanel(new GridLayout(2,1));
            ImageIcon L1 = new ImageIcon(u.getVeritable_Panier().monpanier.get(i).imageArt);
            JLabel POL1=new JLabel(L1);
            POL1.setVerticalTextPosition(JLabel.BOTTOM);
            POL1.setHorizontalTextPosition(JLabel.CENTER);
            POL1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            POL1.setText(u.getVeritable_Panier().monpanier.get(i).nom);
            cel.add(POL1, BorderLayout.CENTER);
            //Bouton
            JButton boutonPlus ;
            JButton boutonMoins ;
            JButton boutonDescription1 ;
            boutonPlus = new JButton(new PlusAction("+",u,u.getMonPanier().get(i)));
            boutonMoins= new JButton(new MoinsAction("-",u,u.getMonPanier().get(i)));
            boutonPlus.setAlignmentX(Component.CENTER_ALIGNMENT);
            boutonMoins.setAlignmentX(Component.CENTER_ALIGNMENT);
            boutonDescription1= new JButton("Description");
            boutonDescription1.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel Quant=new JLabel("QUANTITE: "+u.getVeritable_Panier().monpanier.get(i).stock);
            Quant.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel Prix=new JLabel("Prix: "+u.getVeritable_Panier().monpanier.get(i).prix);
            Prix.setAlignmentX(Component.CENTER_ALIGNMENT);


            JPanel PB = new JPanel(new GridLayout(5, 1,0,0));
            PB.add(boutonPlus);
            PB.add(boutonMoins);
            PB.add(boutonDescription1);
            PB.add(Quant);
            PB.add(Prix);

            cel.add(PB, BorderLayout.EAST);
            //Esapce entre les articles
            cel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ajout de la marge


            EspacePanier.add(cel);
        }

        JPanel MontantTotal=new JPanel(new GridLayout(1,2,15,30));
        JLabel Montant=new JLabel("TOTAL: "+TotalPanier+" €");
        Valider=new JButton(new ValiderPanierAction("Valider",panel,TotalPanier,u));
        Valider.setAlignmentX(Component.CENTER_ALIGNMENT);

        MontantTotal.add(Montant);
        MontantTotal.add(Valider);

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        panel.add(EspacePanier);
        panel.add(MontantTotal);




        ///=============================================================
        panel.add(panelClient, BorderLayout.CENTER);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

}
