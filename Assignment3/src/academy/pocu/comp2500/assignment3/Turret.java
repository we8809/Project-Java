package academy.pocu.comp2500.assignment3;

public class Turret extends Unit implements IThinkable {
    public Turret(IntVector2D position) {
        super(UnitType.GROUND, 99, 2, 0, 7, UnitType.AIR, position);
    }

    @Override
    public AttackIntent attack() {
        return super.attackIntent;
    }

    @Override
    public void onSpawn() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        simulationManager.registerThinkable(this);
    }

    @Override
    public char getSymbol() {
        return 'U';
    }

    @Override
    public void think() {

    }
}
