package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class PrintableProduct extends Product {
    private ArrayList<Aperture> apertures = new ArrayList<Aperture>();
    final private Orientation orientation;

    protected PrintableProduct(String name, Color color, Size size, int price, Orientation orientation) {
        super(name, color, size, price);
        this.orientation = orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return this.apertures;
    }

    public boolean addAperture(Aperture aperture) {
        if (this.apertures.contains(aperture)) {
            return false;
        }

        if (aperture.getX() >= super.getWidth() || aperture.getY() >= super.getHeight()) {
            return false;
        }

        if (aperture.getX() + aperture.getWidth() <= 0 || aperture.getY() + aperture.getHeight() <= 0) {
            return false;
        }

        this.apertures.add(aperture);
        super.price += 5;

        return true;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }
}
