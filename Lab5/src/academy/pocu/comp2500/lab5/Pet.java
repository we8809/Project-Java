package academy.pocu.comp2500.lab5;

public class Pet {
    private String name;
    private int offense;

    public Pet(String name, int offense) {
        this.name = name;
        this.offense = offense;
    }

    public String getName() {
        return this.name;
    }

    public int getOffense() {
        return this.offense;
    }
}
