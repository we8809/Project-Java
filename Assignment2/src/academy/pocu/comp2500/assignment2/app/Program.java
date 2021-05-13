package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;

import academy.pocu.comp2500.assignment2.App;
import academy.pocu.comp2500.assignment2.registry.Registry;

import java.util.HashSet;

public class Program {

    public static void main(String[] args) {
        validateMainTest1();

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        System.out.println("Test complete");
    }

    public static void validateMainTest1() {
        /* 3.1, 3.2 */
        //Red stamp
        Stamp redStamp = new Stamp("seunghwan", StampColor.RED, StampSize.SIZE_70X40);
        assert (redStamp.getText().equals("seunghwan"));
        assert (redStamp.getStampSize() == StampSize.SIZE_70X40);
        assert (redStamp.getStampColor() == StampColor.RED);
        redStamp.setShippingMethod(ShippingMethod.SHIP);

        Cart cart = new Cart();
        assert (!cart.removeProduct(redStamp));
        assert (cart.addProduct(redStamp));
        redStamp.setShippingMethod(ShippingMethod.SHIP);
        assert (redStamp.getShippingMethod() == ShippingMethod.SHIP);
        assert (cart.getTotalPrice() == 2600);
        assert (cart.removeProduct(redStamp));
        assert (cart.getTotalPrice() == 0);
    }
}
