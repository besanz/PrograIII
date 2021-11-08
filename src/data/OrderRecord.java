package data;

public class OrderRecord extends User{

    private int idOrder;
    private int totalSpent;

    /**
     * @param idUser
     * @param name
     * @param username
     * @param password
     * @param isAdmin
     */

    public OrderRecord(int idUser, String name, String username, String password, boolean isAdmin) {
        super(idUser, name, username, password, isAdmin);
        this.idOrder = idOrder;
        this.totalSpent = totalSpent;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }
}
