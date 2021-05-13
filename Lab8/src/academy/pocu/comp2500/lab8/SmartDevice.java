package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected boolean isOn;
    protected int stateUpdatedTick;
    protected int currentTick;

    public SmartDevice() {

    }

    public final boolean isOn() {
        return this.isOn;
    }

    public abstract void onTick();

    public final int getTicksSinceLastUpdate() {
        return this.stateUpdatedTick;
    }

    public abstract void installToPlanter(Planter planter);
}
