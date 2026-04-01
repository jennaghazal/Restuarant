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
    ArrayList<MenuItem> menuItems = new ArrayList<>();
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
    JTable table = new JTable();
    JScrollPane ttable = new JScrollPane();
    ArrayList<String> headings = new ArrayList<>();
    ArrayList<item> activeOrders = new ArrayList<>();
    double tips = 0;
    JLabel totalText = new JLabel();
    JLabel subText = new JLabel();
    JLabel tipText = new JLabel();
    JLabel tip = new JLabel("Tip amount");
    JTextField tipField = new JTextField();
    public framing(){
        setLayout(null);
        setSize(700,700);

        setBackground(new Color(227, 238, 255));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        activePanel.setLayout(null);
        activePanel.setBounds(20,20,400,500);
        activePanel.setVisible(true);
        testButton.setBounds(40,100,50,30);
        activePanel.add(testButton);
        Image weafResize = weafeon.getImage();
        weafy.setBounds(100,600,50,50);add(weafy);
//        add(activePanel);
        appetizers.setBounds(0,0,640,500);
        appetizers.setPreferredSize(new Dimension(640, 1600));
        entrees.setBounds(0,0,640,500);
        entrees.setPreferredSize(new Dimension(640, 1200));
        desserts.setBounds(0,0,640,500);
        desserts.setPreferredSize(new Dimension(640, 1200));
        checkOut.setBounds(0,0,640,500);
        appetizers.setBackground(Color.PINK);
        appetizers.setLayout(null);
        entrees.setLayout(null);
        desserts.setLayout(null);
        mainScroll.setBounds(20,20,640,500);
        mainScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(mainScroll);
        //make an arraylist of items on the menu!! (so a jpanel with image, text heading and desc, price, buttons)
        JPanel app1 = new JPanel();
        app1.setLayout(null);
        app1.setBounds(30,30,580,200);

        //470-250 = 220
//        app1.add(weafy);
//        weafy.setBounds(375,20,150,150);
//        JTextArea app1Desc = new JTextArea("this is a test aareeaa.. blwwggghh imagine this is a good description about food or smth");
//        app1Desc.setBounds(40,20,250,100);
//        app1Desc.setLineWrap(true);
//        app1.add(app1Desc);
//        JButton app1Plus = new JButton("+1 order");
//        JButton app1Minus = new JButton("-1 order");
//        app1Minus.setEnabled(false);
//        app1.add(app1Plus);
//        app1.add(app1Minus);
//        app1Minus.setBounds(60,140,90,30);
//        app1Plus.setBounds(180,140,90,30);
//
//        appetizers.add(app1);
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

        menuItems.add(new MenuItem("takoyaki", "octopus fried in batter", 5.00, 0, "src/Restaraunt/Healing Kuma Takoyaki.jpeg"));
        menuItems.add(new MenuItem("lemon shrimp", "lemony shrimp", 6.00, 0,"src/Restaraunt/shrimp.jpeg"));
        menuItems.add(new MenuItem("greek salad", "a classic salad", 4.50, 0, "src/Restaraunt/greeksalad.jpeg"));
        menuItems.add(new MenuItem("falafel", "levantine pressed falafel", 5.00, 0,"src/Restaraunt/Homemade Falafel.jpeg"));
        menuItems.add(new MenuItem("fried cauliflower", "bowl of cauliflower stems fried, comes with garlic sauce", 3.50,0,"src/Restaraunt/Crispy Roasted Cauliflower.jpeg"));
        menuItems.add(new MenuItem("rice bowl", "basic bowl of white rice", 2.00, 0, "src/Restaraunt/ricebowl.jpeg"));

        menuItems.add(new MenuItem("cat fish sandwiches", "cod sandwiches with lettuce", 8.00, 1,"src/Restaraunt/Cat burger.JPG"));
        menuItems.add(new MenuItem("chicken teriyaki", "teriyaki seasoned chicken, comes with rice", 10.00, 1,"src/Restaraunt/Teriyaki.JPG"));
        menuItems.add(new MenuItem("seal sushi", "sushi fit for a seal - 6 rolls of choice (eel, scallop, salmon, crab, more)", 10.00, 1, "src/Restaraunt/Sushi.JPG"));
        menuItems.add(new MenuItem("coconut curry", "classic coconut curry", 12.00, 1, "src/Restaraunt/Curry.JPG"));

        menuItems.add(new MenuItem("tiramisu", "layered coffee cake with ladyfingers", 6.00, 2, "src/Restaraunt/Tiramisu.JPG"));
        menuItems.add(new MenuItem("seal ice cream", "lavender flavored ice cream with waffle cone, black carrayway and sesame seeds on top", 4.00,2, "src/Restaraunt/Seal ice cream.JPG"));
        menuItems.add(new MenuItem("cheesecake", "classic new york style cheesecake with random animal topping", 4.50, 2, "src/Restaraunt/Cheesecake.JPG"));
        menuItems.add(new MenuItem("raspberry tarts", "assortment of raspberry tarts", 6.50, 2, "src/Restaraunt/Tart.JPG"));
        int yApp = 30;
        int yEnt = 30;
        int yDes = 30;
        for(int a = 0; a < menuItems.size();a++){
            if(menuItems.get(a).getCategory() ==0){
                appetizers.add(create(menuItems.get(a), yApp, Color.WHITE));
                yApp+= 220;
            }
            if(menuItems.get(a).getCategory() ==1){
                entrees.add(create(menuItems.get(a), yEnt, Color.WHITE));
                yEnt+= 220;
            }
            if(menuItems.get(a).getCategory() == 2){
                desserts.add(create(menuItems.get(a), yDes, Color.WHITE));
                yDes+= 220;
            }

        }
        checkOut.setLayout(null);

        headings.add("item");
        headings.add("subtotal");

        table = new JTable(new String[0][2], headings.toArray());
        table.setBounds(0,0,300,300);
        ttable = new JScrollPane(table);
        ttable.setBounds(0,0,300,300);
        checkOut.add(ttable);
        subText.setBounds(400,20,150,40);
        tipText.setBounds(400,60,150,40);
        totalText.setBounds(400,100,150,40);
        checkOut.add(subText);
        checkOut.add(tipText);
        checkOut.add(totalText);
        tip.setBounds(320, 140, 150,20);
        checkOut.add(tip);
        tipField.setBounds(400,140,70,20);
        checkOut.add(tipField);

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
            updateTable();
        }
        JScrollPane appetPane = new JScrollPane(activePanel);
        add(appetPane);
        mainScroll.setViewportView(activePanel);

        revalidate();
        repaint();

        //activePanel = ;
    }

    public JPanel create(MenuItem food, int y, Color color){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);


        JTextArea panelText = new JTextArea(food.getDescription());
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
        if(food.getOrderCt()<1){
            panelMinus.setEnabled(false);
        }
        else{
            panelMinus.setEnabled(true);
        }

        panel.add(panelPlus);
        panel.add(panelMinus);
        panelPlus.addActionListener(e-> addOrder(food,panel));

//        panelMinus.addActionListener(e-> refresh(panel, food));
        panelMinus.addActionListener(e-> removeOrder(food, panel));
        panelMinus.setBounds(60,110,90,30);
        panelPlus.setBounds(180,110,90,30);
        JLabel orders = new JLabel(food.getOrderCt()+"");
        JLabel price = new JLabel("$"+food.getCost()+"");
        price.setBounds(40,160,90,30);
        orders.setBounds(40,140,90,30);
        panel.add(orders);
        panel.add(price);

        ImageIcon img = new ImageIcon(food.getFileName());

        Image image = img.getImage();
        image = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        img = new ImageIcon(image);



        JLabel imageLabel = new JLabel(img);

        imageLabel.setBounds(400,40,100,100);

        panel.add(imageLabel);

        panel.setBounds(20,y,580,200);
        panel.revalidate();
        panel.repaint();
        return panel;
    }

    public void addOrder(MenuItem food, JPanel panel){
        food.addOrder();
        refresh(panel, food);
    }
    public void removeOrder(MenuItem food, JPanel panel){
        food.removeOrder();
        refresh(panel, food);
    }
    public void refresh(JPanel panel, MenuItem food){
//        Container parent = panel.getParent();
//        int index = parent.getComponentZOrder(panel);
//        parent.remove(panel);
//        JPanel newPanel = create(food, panel.getY(), panel.getBackground());
//        parent.add(newPanel, index);
//        parent.revalidate();
//        parent.repaint();
        JPanel newPanel = create(food, panel.getY(), panel.getBackground());
        if(food.getCategory() == 0){
            appetizers.remove(panel);
            appetizers.add(newPanel);
        }
        else if(food.getCategory() == 1){
            entrees.remove(panel);
            entrees.add(newPanel);
        }
        else{
            desserts.remove(panel);
            desserts.add(newPanel);
        }
        appetizers.revalidate();
        appetizers.repaint();
        entrees.repaint();
        entrees.revalidate();
        desserts.repaint();
        desserts.revalidate();
    }
    public void updateTable(){
        checkOut.remove(ttable);
        ArrayList<MenuItem> active = new ArrayList<>();
        for(int a = 0; a< menuItems.size(); a++){
            if(menuItems.get(a).getOrderCt() > 0){
                for(int b = 0; b < menuItems.get(a).getOrderCt(); b++){
                    active.add(menuItems.get(a));
                }
            }
        }
        String[][] data = new String[active.size()][2]; //edit this to be no of headers and the icecreams is an arraylist of icecream
        int row = 0;
        for(MenuItem i: active){
            data[row][0] = i.getName();
            data[row][1] = i.getCost() + "";

            row++;
        }
        ttable.remove(table);
        System.out.println("new table?");
        table = new JTable(data, headings.toArray());
        ttable.setViewportView(table);
        ttable.revalidate();
        ttable.repaint();
        //recalculate jlabels for subtotal, total, and tip here!!!
        double total = calcTotal(active);
        double subTotal = calcSubtotal(active);
        double tipAmount = calcTip(active);
        if(!tipField.getText().isEmpty()){
            tips = Double.parseDouble(tipField.getText());
        }

        checkOut.remove(subText);
        checkOut.remove(tipText);
        checkOut.remove(totalText);
        subText = new JLabel("subtotal: " + subTotal);
        tipText = new JLabel("tip: " + tipAmount);
        totalText = new JLabel("total: " + total);
        subText.setBounds(400,20,150,40);
        tipText.setBounds(400,60,150,40);
        totalText.setBounds(400,100,150,40);
        checkOut.add(subText);
        checkOut.add(tipText);
        checkOut.add(totalText);
        checkOut.add(ttable);
        checkOut.repaint();
        checkOut.revalidate();
    }

    public double calcTotal(ArrayList<MenuItem> active){

        double total = 0;
        for(int a =0; a< active.size();a++){
            total+= active.get(a).getCost();
        }
        total+= (total*(tips*0.1));
        return total;
    }

    public double calcSubtotal(ArrayList<MenuItem> active){
        double sub = 0;
        for(int a =0; a< active.size();a++){
            sub+= active.get(a).getCost();
        }
        return sub;
    }

    public double calcTip(ArrayList<MenuItem> active){
        return calcSubtotal(active) * (tips*0.01);
    }
}
