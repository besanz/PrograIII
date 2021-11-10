package data;

import java.util.ArrayList;

public class Order extends User {
	
	private int price;
	private int totalPaid;

	public Order(int idUser, String username, String password, boolean isAdmin, int price, int totalPaid) {
		super(idUser, username, password, isAdmin);
		this.price = price;
		this.totalPaid = totalPaid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(int totalPaid) {
		this.totalPaid = totalPaid;
	}
}