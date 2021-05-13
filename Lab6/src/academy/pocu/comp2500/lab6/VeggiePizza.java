package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        super(PizzaType.VEGGIE, 17);
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.MOZZARELLA_CHEESE);
        ++(this.cheeseCount);

        super.isValid = isValidVeggiePizza();

        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.MOZZARELLA_CHEESE);
        if (isRemoved) {
            --(this.cheeseCount);
        }

        super.isValid = false;

        return isRemoved;
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.CHEDDAR_CHEESE);
        ++(this.cheeseCount);

        super.isValid = isValidVeggiePizza();

        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = this.toppings.remove(Topping.CHEDDAR_CHEESE);
        if (isRemoved) {
            --(this.cheeseCount);
        }

        super.isValid = false;

        return isRemoved;
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.FETA_CHEESE);
        ++(this.cheeseCount);

        super.isValid = isValidVeggiePizza();

        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.FETA_CHEESE);
        if (isRemoved) {
            --(this.cheeseCount);
        }

        super.isValid = false;

        return isRemoved;
    }

    private boolean isValidVeggiePizza() {
        return super.cheeseCount == super.maxCheeseCount;
    }
}
