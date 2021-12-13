package data;

import java.util.ArrayList;

public class Order extends User {
	
	private int idOrder;
	private int totalPaid;

	public Order(int idUser, String username, String password, boolean isAdmin, int idOrder, int totalPaid) {
		super(idUser, username, password, isAdmin);
		this.idOrder = idOrder;
		this.totalPaid = totalPaid;
	}

	public Order(int idOrder,  int totalpaid, int idUser) {
		super();
		this.idOrder=idOrder;
		this.totalPaid=totalpaid;
	}

	public int getidOrder() {
		return idOrder;
	}

	public void idOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(int totalPaid) {
		this.totalPaid = totalPaid;
	}
}