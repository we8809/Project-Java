package academy.pocu.comp2500.assignment3;

public class Mine extends Unit implements IThinkable {
    private int pushedLimitCount;
    private int pushedCount;

    public Mine(IntVector2D position, int pushedLimitCount) {
        super(UnitType.GROUND, 1, 0, 0, 10, UnitType.GROUND, position);
        this.pushedLimitCount = pushedLimitCount;
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
        return 'N';
    }

    @Override
    public void think() {

    }
}
