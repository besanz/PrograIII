package Data;

import java.util.ArrayList;

/**
 * @author Beñat
 */

public class Client extends User implements IBasket{

    private ArrayList<Product> basket;
    /**
     *
     * @param userName
     * @param password
     * @param isAdmin
     */
    public Client(String userName, String password, boolean isAdmin) {
        super(userName, password, isAdmin);
    }

    public void addBasket(Product p){
        this.basket.add(p);
    }

    public void removeBasket(Product p){
        this.basket.remove(p);
    }

    public void clearBasket() {
        this.basket.clear();
    }


    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<Product> basket) {
        this.basket = basket;
    }

    /**
     * Sum total price of basket.
     * @return
     */

    public double totalBasketPrice(){

        double sum = 0;
        for (Product product : basket) {
            sum += product.getPrice();
        }
        return sum;
    }

    /**
     * Get total number of selected elements in basket.
     * @return
     */

    public int selectedElements(){
        return this.basket.size();
    }
}
