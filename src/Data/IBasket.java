package Data;

/**
 * @author Beñat;
 */

public interface IBasket {

    /**
     *
     * @param p
     */

    public void addBasket(Product p);
    public void removeBasket(Product p);
    public void clearBasket();
    public double totalBasketPrice();
    public int selectedElements();
}