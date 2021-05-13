package academy.pocu.comp2500.assignment3;

public class Tank extends Unit implements IMovable, IThinkable {
    private TankMode mode;

    public Tank(IntVector2D position) {
        super(UnitType.GROUND, 85, 3, 1, 8, UnitType.GROUND, position);
        this.mode = TankMode.TANK;
    }

    @Override
    public AttackIntent attack() {
        return super.attackIntent;
    }

    @Override
    public void onSpawn() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        if (this.mode == TankMode.TANK) {
            simulationManager.registerMovable(this);
        } else {
            simulationManager.registerThinkable(this);
        }
    }

    @Override
    public char getSymbol() {
        return 'T';
    }

    @Override
    public void move() {

    }

    @Override
    public void think() {

    }
}
