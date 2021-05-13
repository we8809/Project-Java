package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Menu {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();

    protected int meatCount;
    protected int cheeseCount;
    protected int veggieCount;

    protected int maxMeatCount;
    protected int maxCheeseCount;
    protected int maxVeggieCount;

    protected Pizza(PizzaType pizzaType, int price) {
        super(price);

        switch (pizzaType) {
            case HOUSE:
                this.toppings.add(Topping.BLACK_OLIVES);
                this.toppings.add(Topping.RED_ONIONS);
                this.toppings.add(Topping.GREEN_PEPPERS);
                this.toppings.add(Topping.MOZZARELLA_CHEESE);
                this.maxMeatCount = 2;
                break;
            case MEAT_LOVERS:
                this.toppings.add(Topping.BACON);
                this.toppings.add(Topping.PEPERONI);
                this.toppings.add(Topping.HAM);
                this.toppings.add(Topping.SAUSAGES);
                this.toppings.add(Topping.CHEDDAR_CHEESE);
                this.maxVeggieCount = 1;
                break;
            case VEGGIE:
                this.toppings.add(Topping.BLACK_OLIVES);
                this.toppings.add(Topping.RED_ONIONS);
                this.toppings.add(Topping.GREEN_PEPPERS);
                this.maxCheeseCount = 2;
                break;
            case FREE_SOUL:
                this.maxMeatCount = 2;
                this.maxVeggieCount = 2;
                this.maxCheeseCount = 1;
                break;
            default:
                break;
        }
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }
}
