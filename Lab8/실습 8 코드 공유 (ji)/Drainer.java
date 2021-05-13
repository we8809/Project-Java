package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private static final int DRAIN_WATER_AMOUNT = -7;
    private final int activeWaterLevel;


    public Drainer(int activeWaterLevel) {
        this.activeWaterLevel = activeWaterLevel;
    }

    public int getActiveWaterLevel() {
        return activeWaterLevel;
    }

    @Override
    public void installTo(Planter planter) {
        planter.installDrainableDevice(this);
        planter.installWaterDetectableDevice(this);
    }

    @Override
    public void onTick() {
        this.tick++;
        this.ticksSinceLastUpdate++;
    }

    @Override
    public void drain(Planter planter) {
        if (this.isOn()) {
            planter.addWater(DRAIN_WATER_AMOUNT);
        }
    }

    @Override
    public void detect(final int waterLevel) {
        if (this.isOn != (waterLevel >= this.activeWaterLevel)) {
            this.isOn = !this.isOn;
            this.ticksSinceLastUpdate = 0;
        }
    }
}
