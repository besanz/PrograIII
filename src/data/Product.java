package data;
import recursividad.Comparation;



/**
 * @author Benat
 */

public class Product implements Comparation<Product> {

    protected int idProduct;
    protected String name;
    protected int price;
    private int stock;

    /**
     * @param idProduct
     * @param name
     * @param price
     * @param stock
     */
    public Product(){};
    public Product(int idProduct, String name, int price,int stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.stock=stock;
    }

    public static double restPrice(Product p2, Product p1) {
        double rest;
        rest = p2.getPrice() - p1.getPrice();
        return rest;
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

    public int getPrice() {
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
    public static int sumarPrecio(int a , int b){
    	int result = a+b;
    	return result;
    }
    public static double sumPrice(Product p1 , Product p2){
		return p1.getPrice()+p2.getPrice();
	}

	@Override
	public String toString() {
		return    name + " (" + price + "$) ";
	}
	@Override
	public boolean compareNum(Product o) {
		if(o.getPrice()>this.price){
			return false;
		}else{
			return true;
		}
	
	}
	@Override
	public boolean compareStr(Product o) {
		// TODO Auto-generated method stub
		return false;
	}
	


    
}
