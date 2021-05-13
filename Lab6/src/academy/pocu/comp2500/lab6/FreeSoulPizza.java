package academy.pocu.comp2500.lab6;

public class FreeSoulPizza extends Pizza {
    public FreeSoulPizza() {
        super(PizzaType.FREE_SOUL, 25);
    }

    public boolean addTopping(Topping topping) {
        if ((isMeat(topping) && this.meatCount >= this.maxMeatCount)
                || (isVeggie(topping) && this.veggieCount >= this.maxVeggieCount)
                || (isCheese(topping) && this.cheeseCount >= this.maxCheeseCount)) {
            return false;
        }

        this.toppings.add(topping);

        if (isMeat(topping)) {
            ++(this.meatCount);
        }

        if (isVeggie(topping)) {
            ++(this.veggieCount);
        }

        if (isCheese(topping)) {
            ++(this.cheeseCount);
        }

        super.isValid = isValidFreeSoulPizza();

        return true;
    }

    public boolean removeTopping(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);
        if (isRemoved) {
            if (isMeat(topping)) {
                --(this.meatCount);
            }

            if (isVeggie(topping)) {
                --(this.veggieCount);
            }

            if (isCheese(topping)) {
                --(this.cheeseCount);
            }

            super.isValid = false;
        }

        return isRemoved;
    }

    private static boolean isMeat(Topping topping) {
        return topping == Topping.BACON
                || topping == Topping.CHICKEN
                || topping == Topping.PEPERONI
                || topping == Topping.SAUSAGES
                || topping == Topping.HAM;
    }

    private static boolean isVeggie(Topping topping) {
        return topping == Topping.BLACK_OLIVES
                || topping == Topping.RED_ONIONS
                || topping == Topping.GREEN_PEPPERS;
    }

    private static boolean isCheese(Topping topping) {
        return topping == Topping.MOZZARELLA_CHEESE
                || topping == Topping.CHEDDAR_CHEESE
                || topping == Topping.FETA_CHEESE;
    }

    private boolean isValidFreeSoulPizza() {
        return this.meatCount == maxMeatCount
                && this.veggieCount == maxVeggieCount
                && this.cheeseCount == maxCheeseCount;
    }
}
