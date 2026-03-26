package Restaraunt;

import javax.swing.*;
//okay so instead of menu tabs i lowk wanna do swapping jpanels through jbuttons
//like, if u click on a button from a jpanel it links to a diff one and makes this one entirely disabled/invisible

public class framing extends JFrame {
//dessertsss: tiramisu, seal ice cream (lavender with black carraway seeds), cheesecake, flan, raspberry tarts
    //appetizers: takoyaki, lemon shrimp, greek salad, falafel, fried cauliflower, rice bowl
    // entrees: sushi platter,
    JPanel mainMenu = new JPanel();
    JButton checkOutButton = new JButton("check out");
    JButton appetizerButton = new JButton("appetizers");
    JButton entreeButton = new JButton("entrees");
    JButton dessertButton = new JButton("desserts");

    public framing(){
        setLayout(null);
        setSize(700,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }
}
