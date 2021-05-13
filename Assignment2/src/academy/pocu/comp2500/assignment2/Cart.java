package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;
    private int totalPrice;

    public Cart() {
        this.products = new ArrayList<Product>();
    }

    public boolean addProduct(Product product) {
        if (this.products.contains(product)) {
            return false;
        }

        this.products.add(product);
        this.totalPrice += product.getPrice();

        return true;
    }

    public boolean removeProduct(Product product) {
        if (!this.products.contains(product)) {
            return false;
        }

        this.products.remove(product);
        this.totalPrice -= product.getPrice();

        return true;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }
}
