package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    public HousePizza() {
        super(PizzaType.HOUSE, 20);
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.BACON);
        ++(super.meatCount);

        super.isValid = isValidHousePizza();

        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = super.toppings.remove(Topping.BACON);
        if (isRemoved) {
            --(super.meatCount);
            super.isValid = false;
        }

        return isRemoved;
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.PEPERONI);
        ++(super.meatCount);

        super.isValid = isValidHousePizza();

        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = super.toppings.remove(Topping.PEPERONI);

        if (isRemoved) {
            --(super.meatCount);
            super.isValid = false;
        }

        return isRemoved;
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.SAUSAGES);
        ++(super.meatCount);

        super.isValid = isValidHousePizza();

        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = super.toppings.remove(Topping.SAUSAGES);
        if (isRemoved) {
            --(super.meatCount);
            super.isValid = false;
        }

        return isRemoved;
    }

    private boolean isValidHousePizza() {
        return super.meatCount == super.maxMeatCount;
    }
}
