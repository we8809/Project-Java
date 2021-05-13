package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected boolean isOn;
    protected int tick;
    protected int ticksSinceLastUpdate;

    public SmartDevice() {
        this.isOn = false;
        this.tick = 0;
        this.ticksSinceLastUpdate = 0;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public abstract void onTick();

    public abstract void installTo(Planter planter);

    public int getTicksSinceLastUpdate() {
        return this.ticksSinceLastUpdate;
    }

}
