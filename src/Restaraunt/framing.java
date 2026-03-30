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
        setResizable(false);
        activePanel.setLayout(null);
        activePanel.setBounds(20,20,400,500);
        activePanel.setVisible(true);
        testButton.setBounds(40,100,50,30);
        activePanel.add(testButton);
        Image weafResize = weafeon.getImage();
        weafy.setBounds(100,300,300,300);
        //add(weafy);
//        add(activePanel);
        appetizers.setBounds(20,20,640,500);
        entrees.setBounds(20,20,640,500);
        desserts.setBounds(20,20,640,500);
        checkOut.setBounds(20,20,640,500);
        appetizers.setBackground(Color.PINK);
        appetizers.setLayout(null);

        //make an arraylist of items on the menu!! (so a jpanel with image, text heading and desc, price, buttons)
        JPanel app1 = new JPanel();
        app1.setLayout(null);
        app1.setBounds(30,30,580,200);
        JPanel app2 = new JPanel();
        app2.setLayout(null);
        app2.setBounds(30,500,580,600);
        appetizers.add(app2);
        app1.add(weafy);
        weafy.setBounds(375,20,150,150);
        JTextArea app1Desc = new JTextArea("this is a test aareeaa.. blwwggghh imagine this is a good description about food or smth");
        app1Desc.setBounds(40,20,250,100);
        app1Desc.setLineWrap(true);
        app1.add(app1Desc);
        JButton app1Plus = new JButton("+1 order");
        JButton app1Minus = new JButton("-1 order");
        app1Minus.setEnabled(false);
        app1.add(app1Plus);
        app1.add(app1Minus);
        app1Minus.setBounds(60,140,90,30);
        app1Plus.setBounds(180,140,90,30);

        appetizers.add(app1);

        entrees.setBackground(Color.CYAN);
        desserts.setBackground(Color.YELLOW);
        checkOut.setBackground(Color.MAGENTA);
        setJMenuBar(menu);
        menu.add(mainMenu);
        menu.add(appMenu);
        menu.add(entMenu);
        menu.add(desMenu);
        menu.add(checkMenu);
        //menu.add(app1Desc);//THIS ISNT TO ACTUALLY ADD! jsut showcase of text in the menyu

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
            JScrollPane appetPane = new JScrollPane(activePanel);
            add(appetPane);
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
