package Restaraunt;

public class item {
    double pricing;
    int category; //just so i remememeberrr.. 0 for ap, 1 for ent 2 for des
    String name;
    //String image directory
    String description;

    public item(String name, String description, int category, double pricing){
        this.name = name;
        this.description = description;
        this.category = category;
        this.pricing = pricing;
    }

    public String getDescription() {
        return description;
    }
    public String getName(){
        return name;
    }

    public double getPricing() {
        return pricing;
    }

    public int getCategory() {
        return category;
    }
}
