package Restaraunt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
    JScrollPane mainScroll = new JScrollPane();

    ArrayList<item> activeOrders = new ArrayList<>();

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
        appetizers.setPreferredSize(new Dimension(640, 1200));
        entrees.setBounds(20,20,640,500);
        entrees.setPreferredSize(new Dimension(640, 1200));
        desserts.setBounds(20,20,640,500);
        desserts.setPreferredSize(new Dimension(640, 1200));
        checkOut.setBounds(20,20,640,500);
        appetizers.setBackground(Color.PINK);
        appetizers.setLayout(null);
        mainScroll.setBounds(20,20,640,500);
        mainScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(mainScroll);
        //make an arraylist of items on the menu!! (so a jpanel with image, text heading and desc, price, buttons)
        JPanel app1 = new JPanel();
        app1.setLayout(null);
        app1.setBounds(30,30,580,200);

        //470-250 = 220
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
        appetizers.add(create(new item("hamborger", "mmmm yuum yum breakfast burrito", 1, 12.0), 250, Color.green));
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
        mainScroll.setViewportView(activePanel);

        revalidate();
        repaint();


        //activePanel = ;
    }

    public JPanel create(item food, int y, Color color){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);
        //panel.add(weafy);
        //weafy.setBounds(375,20,150,150);
        JTextArea panelText = new JTextArea("this is a test aareeaa.. blwwggghh imagine this is a good description about food or smth");
        panelText.setEditable(false);
        panelText.setBounds(40,20,250,70);
        panelText.setWrapStyleWord(true);
        panelText.setLineWrap(true);
        panel.add(panelText);
        //new image from the diraectory
        //Image.setBounds(375,60,150,150);
        //add img
        JLabel foodName = new JLabel(food.getName());
        foodName.setBounds(425,5,100,40);
        panel.add(foodName);
        JButton panelPlus = new JButton("+1 order");
        JButton panelMinus = new JButton("-1 order");
        panelMinus.setEnabled(false);
        panel.add(panelPlus);
        panel.add(panelMinus);
        panelPlus.addActionListener(e-> addOrder(food));
        panelMinus.addActionListener(e-> removeOrder(food));
        panelMinus.setBounds(60,110,90,30);
        panelPlus.setBounds(180,110,90,30);
        JLabel orders = new JLabel("0");
        JLabel price = new JLabel("$"+food.getPricing()+"");
        price.setBounds(40,160,90,30);
        orders.setBounds(40,140,90,30);
        panel.add(orders);
        panel.add(price);
        panel.setBounds(30,y,580,200);
        return panel;
    }

    public void addOrder(item food){
        activeOrders.add(food);
    }
    public void removeOrder(item food){
        activeOrders.remove(food);
        if(!activeOrders.contains(food)){
            //disable that panels panelMinus button
        }
    }


}
