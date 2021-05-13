package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet pet;

    public Knight(String name, int hp, int offense, int defense) {
        super(name, hp, offense, defense);
    }

    public void setPet(Pet pet) {
        if (pet == null) {
            this.pet = null;
        }

        this.pet = pet;
    }

    public void attackTogether(Barbarian otherKnight) {
        if (!isAlive()) {
            return;
        }

        if (this.name.equals(otherKnight.name) || pet == null) {
            return;
        }

        if (!otherKnight.isAlive()) {
            return;
        }

        double damage = (double) (this.offense + pet.getOffense() - otherKnight.defense) / 2.0;

        otherKnight.hp -= (damage < 1.0) ? 1 : Math.min(otherKnight.hp, (int) damage);
    }
}
