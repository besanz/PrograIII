package Data;
<<<<<<< HEAD
//guten
=======

>>>>>>> 72c11619988a0ceab44e6e51422cfb8dadb4288f
import exceptions.BasketException;

import java.util.ArrayList;

public class Basket {

    private int id;
    private final ArrayList<Product>products;
    private int amount;

    public Basket(int id, ArrayList<Product> products, int amount) {
        this.id = id;
        this.products = products;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @Author Beñat
     *
     * This method adds a product at the current basket, while showing real-time total number of products in it,
     * so it may as well change that value.
     *
     * NOT FINISHED!
     *
     * @param product
     * @throws BasketException
     */

    public void addProducts(final Product product) throws BasketException {
        if (product != null) {
            int currentAmount = this.products.size();
            currentAmount += currentAmount;
            this.products.add(product);
        } else {
            throw new BasketException("You cannot add Null objects to Basket!");
        }
    }

    /**
     * @author Beñat
     *
     * This method removes a product from the current basket, while showing real-time total number of products in it,
     * so it may as well change that value.
     *
     * NOT FINISHED!
     *
     * @param product
     * @throws BasketException
     */


    public void removeProducts(final Product product) throws BasketException {
        if (product != null) {
            int currentAmount = this.products.size();
            currentAmount += currentAmount;
        } else {
            throw new BasketException("Cannot remove %d instances of product as there are only %d instances!");
        }
    }


}
