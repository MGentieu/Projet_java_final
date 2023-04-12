package vue;

import javax.swing.*;
import java.awt.*;

public class Apropos {

    public static JPanel create_page_apropos(JPanel pageApropos) {
        String text = """
                Bienvenue sur BookLand, votre librairie en ligne préférée ! Chez BookLand, nous croyons que la lecture est l'une des plus grandes joies de la vie, et nous sommes passionnés par l'idée de vous aider à découvrir les livres qui vous toucheront le plus.
                                
                \nNous sommes fiers de proposer une large sélection de livres de toutes sortes, allant des best-sellers les plus populaires aux livres spécialisés les plus pointus, en passant par les classiques intemporels. Chez BookLand, nous savons que chaque lecteur est différent, c'est pourquoi nous avons à cœur de proposer une collection variée et éclectique pour satisfaire tous les goûts et toutes les envies.
                                
                \nNotre équipe de passionnés de livres est dévouée à vous offrir la meilleure expérience d'achat possible. Nous avons mis en place un processus facile et pratique pour commander vos livres préférés, et nous sommes toujours à votre disposition pour vous aider à trouver le livre parfait pour vous ou pour offrir en cadeau.
                                
                \nChez BookLand, nous sommes également soucieux de l'environnement. Nous travaillons avec des éditeurs et des fournisseurs engagés dans des pratiques durables pour réduire notre impact sur la planète, et nous sommes fiers d'offrir une sélection croissante de livres écologiques.
                                
                \nNous espérons que vous apprécierez notre sélection de livres et notre engagement envers la satisfaction de nos clients. Merci de choisir BookLand pour tous vos besoins en matière de lecture en ligne !
                """;
        pageApropos.setLayout(new BoxLayout(pageApropos, BoxLayout.Y_AXIS));
        pageApropos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("<html><div style='text-align:center; font-family:Arial; font-size:18px;'>"+ text.replaceAll("\n", "<br/>") + "</div></html>");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageApropos.add(label);
        return pageApropos;
    }
}
