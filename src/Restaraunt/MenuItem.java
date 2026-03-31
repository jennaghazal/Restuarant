package Restaraunt;


public class MenuItem{

    String name;
    String description;
    double cost;
    int category;
    int orderCt;
    public MenuItem(String name, String description, double cost, int category){

        this.name = name;
        this.description = description;
        this.cost = cost;
        this.category = category;

        orderCt = 0;

    }


    public String getDescription() {
        return description;
    }

    public String getName(){
        return name;
    }

    public double getCost() {
        return cost;
    }
    public int getCategory() {
        return category;
    }

    public void addOrder(){
        orderCt++;

    }
    public void removeOrder(){
        orderCt--;
        if(orderCt <=0){

        }
    }
    public int getOrderCt(){
        return orderCt;
    }

}
