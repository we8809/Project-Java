package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private static final int DRAIN_AMOUNT_LITER_PER_TICK = 7;

    private final int triggerWaterLevel;
    private int detectedWaterLevel;

    public Drainer(int triggerWaterLevel) {
        super(SmartDeviceType.DRAINER);

        assert (triggerWaterLevel >= 0);

        this.triggerWaterLevel = triggerWaterLevel;
        this.detectedWaterLevel = 0;
    }

    public int getDrainAmountLiterPerTick() {
        return DRAIN_AMOUNT_LITER_PER_TICK;
    }

    @Override
    public void drain(Planter planter) {
        assert (planter != null);

        if (isOn()) {
            planter.drain(this);
        }
    }

    @Override
    public void detect(final int waterLevel) {
        detectedWaterLevel = waterLevel;
    }

    @Override
    protected boolean getNextIsOn(final int nowTick) {
        return (detectedWaterLevel >= triggerWaterLevel);
    }
}
