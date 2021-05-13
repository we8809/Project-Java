package academy.pocu.comp2500.assignment2;

public class Product {
    final private String name;
    final private Color color;
    final private int width;
    final private int height;
    protected int price;

    private ShippingMethod shippingMethod;

    protected Product(String name, Color color, Size size, int price) {
        this.name = name;
        this.color = color;
        this.width = size.getWidth();
        this.height = size.getHeight();
        this.price = price;
        this.shippingMethod = ShippingMethod.PICKUP;
    }

    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return this.color;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPrice() {
        return this.price;
    }

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
