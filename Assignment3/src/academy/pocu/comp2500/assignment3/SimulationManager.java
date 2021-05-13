package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class SimulationManager {
    private static final int NUM_COLUMNS = 16;
    private static final int NUM_ROWS = 8;
    private static SimulationManager instance;

    private ArrayList<Unit> units = new ArrayList<>();
    ArrayList<ArrayList<ArrayList<Unit>>> unitPositions = new ArrayList<>();
    private ArrayList<IThinkable> thinkableUnits = new ArrayList<>();
    private ArrayList<IMovable> movableUnits = new ArrayList<>();

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }

        return instance;
    }

    private SimulationManager() {
        for (int i = 0; i < NUM_ROWS; ++i) {
            this.unitPositions.add(new ArrayList<>());

            for (int j = 0; j < NUM_COLUMNS; ++j) {
                this.unitPositions.get(i).add(new ArrayList<>());
            }
        }
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public ArrayList<Unit> getUnitsFromPosition(int x, int y) {
        ArrayList<Unit> units = this.unitPositions.get(y).get(x);
        return units;
    }

    public void spawn(Unit unit) {
        this.units.add(unit);

        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();

        this.unitPositions.get(y).get(x).add(unit);

        unit.onSpawn();
    }

    public void registerThinkable(IThinkable thinkable) {
        this.thinkableUnits.add(thinkable);
    }

    public void registerMovable(IMovable movable) {
        this.movableUnits.add(movable);
    }

    public void registerCollisionEventListener(Unit listener) {

    }

    public void update() {
        for (IThinkable thinkableUnit : this.thinkableUnits) {
            thinkableUnit.think();
        }

        for (IMovable movableUnit : this.movableUnits) {

        }
    }
}
