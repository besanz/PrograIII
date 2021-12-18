package data;

public class ProductBasket {
	protected int idProduct;
	protected String name;
	protected int price;

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

	private int purchaseQuantity;

	public ProductBasket(int idProduct, String name, int price) {
		this.setIdProduct(idProduct);
		this.setPrice(price);
		this.setName(name);
		// super(idProduct,name,d,0);
		this.purchaseQuantity = 1;
	}

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = hash+this.getIdProduct();
		return hash;
	}

	@Override
	public String toString() {
		return this.getName() + (this.getPurchaseQuantity() > 1 ? "s" : "") + " (" + this.getPurchaseQuantity() + ") ";
	}
}
