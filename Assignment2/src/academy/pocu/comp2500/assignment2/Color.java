package academy.pocu.comp2500.assignment2;

public class Color {
    final private int r;
    final private int g;
    final private int b;

    public Color(int r, int g, int b) {
        this.r = (r > 255) ? 255 : Math.max(r, 0);
        this.g = (g > 255) ? 255 : Math.max(g, 0);
        this.b = (b > 255) ? 255 : Math.max(b, 0);
    }

    public int getRgb() {
        return (r << 16 | g << 8 | b);
    }

    public int getR() {
        return this.r;
    }

    public int getG() {
        return this.g;
    }

    public int getB() {
        return this.b;
    }
}
