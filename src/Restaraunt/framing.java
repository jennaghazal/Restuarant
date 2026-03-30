package Restaraunt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//okay so instead of menu tabs i lowk wanna do swapping jpanels through jbuttons
//like, if u click on a button from a jpanel it links to a diff one and makes this one entirely disabled/invisible

public class framing extends JFrame {
//dessertsss: tiramisu, seal ice cream (lavender with black carraway seeds), cheesecake, flan, raspberry tarts
    //appetizers: takoyaki, lemon shrimp, greek salad, falafel, fried cauliflower, rice bowl
    // entrees: sushi platter,
    JPanel activePanel = new JPanel();

    ImageIcon weafeon = new ImageIcon("src/Restaraunt/weafeon!!.jpg");
    JMenu mainMenu = new JMenu();
    JMenuBar menu = new JMenuBar();
    JMenuItem appMenu = new JMenuItem("appetizers");
    JMenuItem entMenu = new JMenuItem("entrees");
    JMenuItem desMenu = new JMenuItem("desserts");
    JMenuItem checkMenu = new JMenuItem("check-out");
    JButton testButton = new JButton("test");
    JPanel checkOut = new JPanel();
    JPanel appetizers = new JPanel();
    JPanel entrees = new JPanel();
    JPanel desserts = new JPanel();
    JLabel weafy = new JLabel(weafeon);

    public framing(){
        setLayout(null);
        setSize(700,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        activePanel.setLayout(null);
        activePanel.setBounds(20,20,400,500);
        activePanel.setVisible(true);
        testButton.setBounds(40,100,50,30);
        activePanel.add(testButton);
        Image weafResize = weafeon.getImage();
        weafy.setBounds(100,300,300,300);
        add(weafy);
        add(activePanel);
        appetizers.setBounds(20,20,400,500);
        entrees.setBounds(20,20,400,500);
        desserts.setBounds(20,20,400,500);
        checkOut.setBounds(20,20,400,500);
        appetizers.setBackground(Color.PINK);
        entrees.setBackground(Color.CYAN);
        desserts.setBackground(Color.YELLOW);
        checkOut.setBackground(Color.MAGENTA);
        setJMenuBar(menu);
        menu.add(mainMenu);
        menu.add(appMenu);
        menu.add(entMenu);
        menu.add(desMenu);
        menu.add(checkMenu);

        appMenu.addActionListener(e-> changePane(e));
        entMenu.addActionListener(e -> changePane(e));
        desMenu.addActionListener(e -> changePane(e));
        checkMenu.addActionListener(e -> changePane(e));

        setVisible(true);
    }


    public void changePane(ActionEvent event){
        remove(activePanel);
        if(event.getActionCommand() == "appetizers"){
            System.out.println(event.getActionCommand());

            activePanel = appetizers;

        }
        else if(event.getActionCommand() == "entrees"){
            System.out.println(event.getActionCommand());
            activePanel = entrees;
        }
        else if (event.getActionCommand() == "desserts") {
            System.out.println(event.getActionCommand());
            activePanel = desserts;
        }
        else if (event.getActionCommand() == "check-out"){
            System.out.println(event.getActionCommand());
            activePanel = checkOut;
        }
        add(activePanel);
        activePanel.repaint();
        //activePanel = ;
    }
}
