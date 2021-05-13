package academy.pocu.comp2500.assignment3;

public class Wraith extends Unit implements IMovable, IThinkable {
    public Wraith(IntVector2D position) {
        super(UnitType.AIR, 80, 4, 0, 6, UnitType.UNIFY, position);
    }

    @Override
    public AttackIntent attack() {
        return super.attackIntent;
    }

    @Override
    public void onSpawn() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        simulationManager.registerMovable(this);
        simulationManager.registerThinkable(this);
    }

    @Override
    public char getSymbol() {
        return 'W';
    }

    @Override
    public void move() {

    }

    @Override
    public void think() {

    }
}
