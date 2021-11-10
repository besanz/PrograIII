package data;

/**
 * @author Beñat
 */

public class Product {

    private int idProduct;
    private String name;
    private int price;
    private int stock;

    /**
     * @param idProduct
     * @param name
     * @param price
     * @param stock
     */

    public Product(int idProduct, String name, int price,int stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.stock=stock;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    
}
