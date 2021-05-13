package academy.pocu.comp2500.lab5;

public class Barbarian {
    protected String name;
    protected int offense;
    protected int defense;
    protected int hp;
    protected final int maxHp;

    public Barbarian(String name, int hp, int offense, int defense) {
        this.name = name;
        this.offense = offense;
        this.defense = defense;
        this.hp = hp;
        this.maxHp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void attack(Barbarian otherBarbarian) {
        if (!isAlive()) {
            return;
        }

        if (this.name.equals(otherBarbarian.name)) {
            return;
        }

        if (!otherBarbarian.isAlive()) {
            return;
        }

        double damage = (double) (this.offense - otherBarbarian.defense) / 2.0;
        otherBarbarian.hp -= (damage < 1.0) ? 1 : Math.min(otherBarbarian.hp, (int) damage);
    }

    public boolean isAlive() {
        if (this.hp > 0) {
            return true;
        }

        return false;
    }
}
