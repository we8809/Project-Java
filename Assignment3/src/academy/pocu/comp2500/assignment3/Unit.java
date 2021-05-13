package academy.pocu.comp2500.assignment3;

public abstract class Unit {
    protected SimulationManager simulationManager;
    private UnitType unitType;
    private int hp;
    protected final int sight;
    protected final int aoe;                /* Area of Effect */
    protected final int ap;
    private IntVector2D position;
    protected AttackIntent attackIntent;

    public Unit(UnitType unitType, int hp, int sight, int aoe, int ap, UnitType attackUnitType, IntVector2D position) {
        this.unitType = unitType;
        this.hp = hp;
        this.sight = sight;
        this.aoe = aoe;
        this.ap = ap;
        this.position = position;
        this.attackIntent = new AttackIntent(this, attackUnitType);
    }

    public final IntVector2D getPosition() {
        return this.position;
    }

    public final int getHp() {
        return this.hp;
    }

    public abstract AttackIntent attack();

    public void onAttacked(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    public abstract void onSpawn();

    public abstract char getSymbol();
}
