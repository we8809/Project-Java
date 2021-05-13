package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private static final int CONSUME_AMOUNT_LITER_PER_TICK = 2;

    private final ArrayList<SmartDevice> smartDevices = new ArrayList<>();
    private final ArrayList<IDrainable> drainables = new ArrayList<>();
    private final ArrayList<ISprayable> sprayables = new ArrayList<>();
    private final ArrayList<IWaterDetectable> waterDetectables = new ArrayList<>();
    private int waterAmount;

    public Planter(int waterAmount) {
        assert (waterAmount >= 0);

        this.waterAmount = waterAmount;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void drain(Drainer drainer) {
        setWaterAmount(waterAmount - drainer.getDrainAmountLiterPerTick());
    }

    public void addWater(Sprinkler sprinkler) {
        setWaterAmount(waterAmount + sprinkler.getSprayAmountLiterPerTick());
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        assert (smartDevice != null);

        smartDevices.add(smartDevice);

        switch (smartDevice.getType()) {
            case SPRINKLER:
                sprayables.add((ISprayable) smartDevice);
                break;
            case DRAINER:
                waterDetectables.add((IWaterDetectable) smartDevice);
                drainables.add((IDrainable) smartDevice);
                break;
            default:
                assert (false) : "Unknown SmartDeviceType";
                break;
        }
    }

    public void tick() {
        for (IWaterDetectable waterDetectable : waterDetectables) {
            waterDetectable.detect(waterAmount);
        }

        for (SmartDevice smartDevice : smartDevices) {
            smartDevice.onTick();
        }

        for (ISprayable sprayable : sprayables) {
            sprayable.spray(this);
        }

        for (IDrainable drainable : drainables) {
            drainable.drain(this);
        }

        setWaterAmount(waterAmount - CONSUME_AMOUNT_LITER_PER_TICK);
    }

    private void setWaterAmount(int waterAmount) {
        this.waterAmount = Math.max(0, waterAmount);
    }
}
