package academy.pocu.comp2500.lab6;

public class Menu {
    private final int price;
    protected boolean isValid;

    protected Menu(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.isValid;
    }
}
