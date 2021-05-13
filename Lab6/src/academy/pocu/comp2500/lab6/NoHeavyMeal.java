package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends ComboMeal {
    public NoHeavyMeal() {
        super(15, 2, 0, 1);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        super.appetizers.clear();
        super.appetizers.add(appetizer1);
        super.appetizers.add(appetizer2);
        super.isValid = super.isValidComboMeal();
    }

    public void setDessert(Dessert dessert) {
        super.desserts.clear();
        super.desserts.add(dessert);
        super.isValid = super.isValidComboMeal();
    }
}
