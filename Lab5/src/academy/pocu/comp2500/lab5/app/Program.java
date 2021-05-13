package academy.pocu.comp2500.lab5.app;

import academy.pocu.comp2500.lab5.*;

public class Program {

    public static void main(String[] args) {
        Gladiator gladiator0 = new Gladiator("Parthunax", 250, 210, 10);
        Gladiator gladiator1 = new Gladiator("Zoro", 100, 150, 65);
        Move move = new Move("gomugomu", 100, 10);

        gladiator0.addMove(move);
        gladiator0.attack("gomugomu", gladiator1);
        System.out.println(String.format("gladiator1's hp = %d", gladiator1.getHp()));

        gladiator0.attack("gomugomu", gladiator1);
        System.out.println(String.format("gladiator1's hp = %d", gladiator1.getHp()));
    }
}
