package data;

import java.util.ArrayList;

import extra.iBasket;

public class Client extends User implements iBasket {

    private ArrayList<Product> basket;

    public Client(int idUser, String username, String password,int saldo, boolean isAdmin) {
        super(idUser,username, password, saldo, isAdmin);
        this.basket = new ArrayList<>();
    }

    public void addProduct(Product p) {
        this.basket.add(p);
    }

    public void removeProduct(Product p){
        this.basket.remove(p);
    }

    public void clearBasket(){
        this.basket.clear();
    }

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<Product> basket) {
        this.basket = basket;
    }

    public double totalBasketPrice(){

        double suma = 0;

        for (Product p : basket) {
            suma += p.getPrice();
        }
        return suma;
    }

    public int selectedElements(){
        return this.basket.size();
    }
}
