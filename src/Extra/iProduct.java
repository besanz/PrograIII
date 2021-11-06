package Extra;

import Data.Product;

public interface iProduct {

    void addProducts(Product product, int amount) throws Exception;

    void removeProducts(Product product, int amount) throws Exception;

    double calculateTotal();
}
