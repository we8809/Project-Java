package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ThreeCourseMeal extends ComboMeal {
    public ThreeCourseMeal() {
        super(25, 1, 1, 1);
    }

    public void setMainCourse(MainCourse mainCourse) {
        super.mainCourses.clear();
        super.mainCourses.add(mainCourse);
        super.isValid = super.isValidComboMeal();
    }

    public void setAppetizer(Appetizer appetizer) {
        super.appetizers.clear();
        super.appetizers.add(appetizer);
        super.isValid = super.isValidComboMeal();
    }

    public void setDessert(Dessert dessert) {
        super.desserts.clear();
        super.desserts.add(dessert);
        super.isValid = isValidComboMeal();
    }
}
