package academy.pocu.comp2500.assignment3;

public class SmartMine extends Unit implements IThinkable {
    private int pushedLimitCount;
    private int pushedCount;
    private int detectLimitCount;
    private int detectCount;

    public SmartMine(IntVector2D position, int pushedLimitCount, int detectLimitCount) {
        super(UnitType.GROUND, 1, 1, 1, 15, UnitType.GROUND, position);
        this.pushedLimitCount = pushedLimitCount;
        this.detectLimitCount = detectLimitCount;
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
        return 'A';
    }

    @Override
    public void think() {

    }
}
