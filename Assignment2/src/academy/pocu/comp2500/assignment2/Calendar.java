package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    final private CalendarType calendarType;

    public Calendar(CalendarType calendarType) {
        super(createName(calendarType), new Color(0xFF, 0xFF, 0xFF), createSize(calendarType), createPrice(calendarType));

        this.calendarType = calendarType;
    }

    private static String createName(CalendarType calendarType) {
        String name = null;

        switch (calendarType) {
            case WALL:
                name = "Wall Calendar";
                break;
            case DESK:
                name = "Desk Calendar";
                break;
            case MAGNET:
                name = "Magnet Calendar";
                break;
            default:
                break;
        }

        return name;
    }

    private static Size createSize(CalendarType calendarType) {
        Size size = null;
        switch (calendarType) {
            case WALL:
                size = new Size(400, 400);
                break;
            case DESK:
                size = new Size(200, 150);
                break;
            case MAGNET:
                size = new Size(100, 200);
                break;
            default:
                break;
        }

        return size;
    }

    private static int createPrice(CalendarType calendarType) {
        int price = 0;
        switch (calendarType) {
            case WALL:
            case DESK:
                price = 1000;
                break;
            case MAGNET:
                price = 1500;
                break;
            default:
                break;
        }

        return price;
    }

    public CalendarType getCalendarType() {
        return this.calendarType;
    }

    /*
    public void setCalendarType(CalendarType calendarType) {
        if (this.calendarType == calendarType) {
            return;
        }

        this.calendarType = calendarType;
        String name = createName(calendarType);
        Size size = createSize(calendarType);
        int price = createPrice(calendarType);

        super.setName(name);
        super.setSize(size);
        super.setPrice(price);
    }
    */
}
