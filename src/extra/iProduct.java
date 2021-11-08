package extra;

import data.Product;
import exceptions.ProductException;

public interface iProduct {

    void addProducts(Product product, int amount) throws ProductException;

    void removeProducts(Product product, int amount) throws ProductException;

    double calculateTotal();
}
