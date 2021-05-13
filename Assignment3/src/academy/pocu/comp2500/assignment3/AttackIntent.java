package academy.pocu.comp2500.assignment3;

public class AttackIntent {
    private IntVector2D attackPosition;
    private final int damage;
    private final int aoe;
    private final UnitType attackUnitType;

    public AttackIntent(Unit attacker, UnitType attackUnitType) {
        this.damage = attacker.ap;
        this.aoe = attacker.aoe;
        this.attackUnitType = attackUnitType;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getAoe() {
        return this.aoe;
    }
}
