package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    final private String text;
    final private StampColor stampColor;
    final private StampSize stampSize;

    public Stamp(String text, StampColor stampColor, StampSize stampSize) {
        super(createName(stampSize), createColor(stampColor), createSize(stampSize), createPrice(stampSize));

        this.stampColor = stampColor;
        this.stampSize = stampSize;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public StampColor getStampColor() {
        return this.stampColor;
    }

    public StampSize getStampSize() {
        return this.stampSize;
    }

    private static String createName(StampSize stampSize) {
        String name = null;

        switch (stampSize) {
            case SIZE_40X30:
                name = "Stamp (40mm x 30mm)";
                break;
            case SIZE_50X20:
                name = "Stamp (50mm x 20mm)";
                break;
            case SIZE_70X40:
                name = "Stamp (70mm x 40mm)";
                break;
        }

        return name;
    }

    private static Color createColor(StampColor stampColor) {
        Color color = null;

        switch (stampColor) {
            case RED:
                color = new Color(0xFF, 0, 0);
                break;
            case GREEN:
                color = new Color(0, 0x80, 0);
                break;
            case BLUE:
                color = new Color(0, 0, 0xFF);
                break;
            default:
                break;
        }

        return color;
    }

    private static Size createSize(StampSize stampSize) {
        Size size = null;

        switch (stampSize) {
            case SIZE_40X30:
                size = new Size(40, 30);
                break;
            case SIZE_50X20:
                size = new Size(50, 20);
                break;
            case SIZE_70X40:
                size = new Size(70, 40);
                break;
            default:
                break;
        }

        return size;
    }

    private static int createPrice(StampSize stampSize) {
        int price = 0;

        switch (stampSize) {
            case SIZE_40X30:
            case SIZE_50X20:
                price = 2300;
                break;
            case SIZE_70X40:
                price = 2600;
                break;
            default:
                break;
        }

        return price;
    }
}
