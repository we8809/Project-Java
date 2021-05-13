package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    private final SmartDeviceType type;
    private boolean isOn;
    private int nowTick;
    private int lastUpdateTick;

    public SmartDeviceType getType() {
        return type;
    }

    public boolean isOn() {
        return isOn;
    }

    public void onTick() {
        ++nowTick;

        if (isOn != getNextIsOn(nowTick)) {
            isOn = !isOn;
            lastUpdateTick = nowTick;
        }
    }

    public int getTicksSinceLastUpdate() {
        return nowTick - lastUpdateTick;
    }

    protected SmartDevice(SmartDeviceType type) {
        assert (type != null);

        this.type = type;
    }

    protected abstract boolean getNextIsOn(final int nowTick);
}
