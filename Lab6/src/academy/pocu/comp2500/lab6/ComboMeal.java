package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ComboMeal extends Menu {
    protected ArrayList<Appetizer> appetizers = new ArrayList<Appetizer>();
    protected ArrayList<MainCourse> mainCourses = new ArrayList<MainCourse>();
    protected ArrayList<Dessert> desserts = new ArrayList<Dessert>();

    final protected int maxAppetizerCount;
    final protected int maxMainCourseCount;
    final protected int maxDessertCount;

    protected ComboMeal(int price, int maxAppetizerCount, int maxMainCourseCount, int maxDessertCount) {
        super(price);
        this.maxAppetizerCount = maxAppetizerCount;
        this.maxMainCourseCount = maxMainCourseCount;
        this.maxDessertCount = maxDessertCount;
    }

    public ArrayList<Appetizer> getAppetizers() {
        assert (this.appetizers.size() != 0) : "call isValid() first!";
        return this.appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        assert (this.mainCourses.size() != 0) : "call isValid() first!";
        return this.mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        assert (this.desserts.size() != 0) : "call isValid() first!";
        return this.desserts;
    }

    protected boolean isValidComboMeal() {
        return this.appetizers.size() == this.maxAppetizerCount
                && this.mainCourses.size() == this.maxMainCourseCount
                && this.desserts.size() == this.maxDessertCount;
    }
}
