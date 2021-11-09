package extra;

import data.Product;

public interface iBasket {

    public void getName();
    public void addProduct(Product p);
    public void removeProduct(Product p);
    public void clearBasket();
    public double totalBasketPrice();
    public int selectedElements();

}
