package data;

import extra.iBasket;

import java.util.ArrayList;

public class Client extends User implements iBasket {

    private ArrayList<Product> basket;

    public Client(int idUser, String name, String username, String password, boolean isAdmin) {
        super(idUser, name, username, password, isAdmin);
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
