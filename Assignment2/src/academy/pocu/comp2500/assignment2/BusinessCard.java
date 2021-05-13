package academy.pocu.comp2500.assignment2;

public class BusinessCard extends PrintableProduct {
    final private BusinessCardType businessCardType;
    final private BusinessCardSides businessCardSides;
    final private BusinessCardColor businessCardColor;

    public BusinessCard(BusinessCardType businessCardType, BusinessCardColor businessCardColor, Orientation orientation, BusinessCardSides businessCardSides) {
        super(createName(businessCardType), createColor(businessCardColor), createSize(orientation), createPrice(businessCardType, businessCardSides), orientation);

        this.businessCardType = businessCardType;
        this.businessCardSides = businessCardSides;
        this.businessCardColor = businessCardColor;
    }

    public BusinessCardType getBusinessCardType() {
        return this.businessCardType;
    }

    public BusinessCardSides getBusinessCardSides() {
        return this.businessCardSides;
    }

    public BusinessCardColor getBusinessCardColor() {
        return this.businessCardColor;
    }

    private static String createName(BusinessCardType businessCardType) {
        String name = null;

        switch (businessCardType) {
            case LAID:
                name = "Laid Business Card";
                break;
            case LINEN:
                name = "Linen Business Card";
                break;
            case SMOOTH:
                name = "Smooth Business Card";
                break;
            default:
                break;
        }

        return name;
    }

    private static Color createColor(BusinessCardColor businessCardColor) {
        Color color = null;
        switch (businessCardColor) {
            case GRAY:
                color = new Color(0xE6, 0xE6, 0xE6);
                break;
            case IVORY:
                color = new Color(0xFF, 0xFF, 0xF0);
                break;
            case WHITE:
                color = new Color(0xFF, 0xFF, 0xFF);
                break;
            default:
                break;
        }

        return color;
    }

    private static Size createSize(Orientation businessCardOrientation) {
        Size size = null;
        switch (businessCardOrientation) {
            case PORTRAIT:
                size = new Size(50, 90);
                break;
            case LANDSCAPE:
                size = new Size(90, 50);
                break;
            default:
                break;
        }

        return size;
    }

    private static int createPrice(BusinessCardType businessCardType, BusinessCardSides businessCardSides) {
        int price = 0;

        switch (businessCardType) {
            case LINEN:
                switch (businessCardSides) {
                    case SINGLE_SIDED:
                        price = 110;
                        break;
                    case DOUBLE_SIDED:
                        price = 140;
                        break;
                    default:
                        break;
                }
                break;
            case LAID:
                switch (businessCardSides) {
                    case SINGLE_SIDED:
                        price = 120;
                        break;
                    case DOUBLE_SIDED:
                        price = 150;
                        break;
                    default:
                        break;
                }
                break;
            case SMOOTH:
                switch (businessCardSides) {
                    case SINGLE_SIDED:
                        price = 100;
                        break;
                    case DOUBLE_SIDED:
                        price = 130;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        return price;
    }
}
