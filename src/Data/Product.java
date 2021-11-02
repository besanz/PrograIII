package Data;

/**
 * @author Beñat
 */

public class Product {

    private String name;
    private static int idAutoInc = 1;
    private int id;
    private double price;

    /**
     *
     * @param name
     * @param id
     * @param price
     */


    public Product(String name, int id, int price){
        this.name = name;
        this.id = idAutoInc++;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
