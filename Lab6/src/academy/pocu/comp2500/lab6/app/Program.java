package academy.pocu.comp2500.lab6.app;

import academy.pocu.comp2500.lab6.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        {
            NoHeavyMeal noHeavyMeal = new NoHeavyMeal();

            assert (!noHeavyMeal.isValid());

            noHeavyMeal.setAppetizers(Appetizer.CALAMARI, Appetizer.GYOZA);

            assert (!noHeavyMeal.isValid());

            noHeavyMeal.setDessert(Dessert.APPLE_PIE);

            assert (noHeavyMeal.isValid());
        }

        {
            DeathByDesserts deathByDesserts = new DeathByDesserts();

            assert (!deathByDesserts.isValid());

            deathByDesserts.setDesserts(Dessert.GREEN_TEA_ICE_CREAM, Dessert.ITALIAN_DONUTS, Dessert.MANGO_PUDDING, Dessert.CHOCOLATE_MOUSSE);

            assert (deathByDesserts.isValid());
        }

        {
            ThreeCourseMeal threeCourseMeal = new ThreeCourseMeal();

            assert (!threeCourseMeal.isValid());

            threeCourseMeal.setAppetizer(Appetizer.GYOZA);
            threeCourseMeal.setDessert(Dessert.CHOCOLATE_MOUSSE);

            assert (!threeCourseMeal.isValid());

            threeCourseMeal.setMainCourse(MainCourse.BOMBAY_BUTTER_CHICKEN);

            assert (threeCourseMeal.isValid());
        }

        {
            HousePizza housePizza = new HousePizza();

            assert (!housePizza.isValid());

            assert (housePizza.addBacon());

            assert (!housePizza.isValid());

            assert (housePizza.addPeperoni());

            assert (housePizza.isValid());

            assert (!housePizza.addSausages());

            assert (housePizza.isValid());

            assert (!housePizza.removeSausages());

            assert (housePizza.removeBacon());

            assert (!housePizza.isValid());

            assert (housePizza.addPeperoni());

            assert (housePizza.isValid());
        }

        {
            MeatLoverPizza meatLoverPizza = new MeatLoverPizza();

            assert (!meatLoverPizza.isValid());

            assert (meatLoverPizza.addGreenPeppers());
            assert (!meatLoverPizza.addGreenPeppers());

            assert (meatLoverPizza.isValid());

            assert (meatLoverPizza.removeGreenPeppers());

            assert (!meatLoverPizza.isValid());
        }

        {
            VeggiePizza veggiePizza = new VeggiePizza();

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addCheddarCheese());

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addFetaCheese());

            assert (veggiePizza.isValid());

            assert (veggiePizza.removeCheddarCheese());

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addMozzarellaCheese());

            assert (veggiePizza.isValid());
        }

        {
            FreeSoulPizza freeSoulPizza = new FreeSoulPizza();

            assert (!freeSoulPizza.isValid());

            assert (freeSoulPizza.addTopping(Topping.FETA_CHEESE));
            assert (!freeSoulPizza.addTopping(Topping.CHEDDAR_CHEESE));

            assert (freeSoulPizza.addTopping(Topping.BLACK_OLIVES));
            assert (freeSoulPizza.addTopping(Topping.RED_ONIONS));

            assert (!freeSoulPizza.isValid());

            assert (!freeSoulPizza.addTopping(Topping.GREEN_PEPPERS));
            assert (!freeSoulPizza.removeTopping(Topping.GREEN_PEPPERS));

            assert (!freeSoulPizza.isValid());

            assert (freeSoulPizza.addTopping(Topping.CHICKEN));
            assert (freeSoulPizza.addTopping(Topping.SAUSAGES));

            assert (freeSoulPizza.isValid());

            assert (!freeSoulPizza.addTopping(Topping.PEPERONI));
        }

        test1();
        test2();
    }

    public static void test1() {
        MeatLoverPizza meatLoverPizza = new MeatLoverPizza();
        boolean isAdded = meatLoverPizza.addGreenPeppers();
        assert (isAdded);

        boolean isRemoved = meatLoverPizza.removeGreenPeppers();
        assert (isRemoved);

        isAdded = meatLoverPizza.addRedOnions();
        assert (isAdded);
        boolean isValid = meatLoverPizza.isValid();
        assert (isValid);

        int price = meatLoverPizza.getPrice();
        assert (price == 21);

        System.out.println("[Topping Lists]");
        ArrayList<Topping> toppings = meatLoverPizza.getToppings();
        for (Topping topping : toppings) {
            System.out.println(topping);
        }
        System.out.println("test1() complete!");
        System.out.println();
    }

    public static void test2() {
        DeathByDesserts deathByDesserts = new DeathByDesserts();
        deathByDesserts.setDesserts(Dessert.GREEN_TEA_ICE_CREAM, Dessert.ITALIAN_DONUTS, Dessert.MANGO_PUDDING, Dessert.CHOCOLATE_MOUSSE);
        assert (deathByDesserts.isValid()); // true
        assert (deathByDesserts.getPrice() == 20);

        NoHeavyMeal noHeavyMeal = new NoHeavyMeal();
        noHeavyMeal.setAppetizers(Appetizer.GYOZA, Appetizer.NACHOS);
        assert (!noHeavyMeal.isValid());
        noHeavyMeal.setDessert(Dessert.GREEN_TEA_ICE_CREAM);
        assert (noHeavyMeal.isValid());
        assert (noHeavyMeal.getPrice() == 15);

        ThreeCourseMeal threeCourseMeal = new ThreeCourseMeal();
        threeCourseMeal.setMainCourse(MainCourse.FISH_AND_CHIPS);
        assert (!threeCourseMeal.isValid());
        threeCourseMeal.setAppetizer(Appetizer.GYOZA);
        assert (!threeCourseMeal.isValid());
        threeCourseMeal.setDessert(Dessert.APPLE_PIE);
        assert (threeCourseMeal.isValid());
        assert (threeCourseMeal.getPrice() == 25);

        System.out.println("test2() complete!");
    }
}
