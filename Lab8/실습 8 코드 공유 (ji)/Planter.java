package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private static final int PLANT_WATER_AMOUNT = -2;

    private int waterAmount;
    private final ArrayList<SmartDevice> smartDevices = new ArrayList<>();
    private final ArrayList<ISprayable> sprayables = new ArrayList<>();
    private final ArrayList<IDrainable> drainables = new ArrayList<>();
    private final ArrayList<IWaterDetectable> waterDetectables = new ArrayList<>();

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public ArrayList<SmartDevice> getSmartDevices() {
        return smartDevices;
    }

    public ArrayList<IDrainable> getDrainables() {
        return drainables;
    }

    public ArrayList<ISprayable> getSprayables() {
        return sprayables;
    }

    public ArrayList<IWaterDetectable> getWaterDetectables() {
        return waterDetectables;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void addWater(int waterAmount) {
        this.waterAmount = Math.max(0, this.waterAmount + waterAmount);
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
        smartDevice.installTo(this);
    }

    public void installSprayableDivice(ISprayable sprayableDevice) {
        this.sprayables.add(sprayableDevice);
    }

    public void installDrainableDevice(IDrainable drainableDevice) {
        this.drainables.add(drainableDevice);
    }

    public void installWaterDetectableDevice(IWaterDetectable waterDetectableDevice) {
        this.waterDetectables.add(waterDetectableDevice);
    }

    public void tick() {
        for (SmartDevice smartDevice : this.smartDevices) {
            smartDevice.onTick();
        }

        for (IWaterDetectable waterDetectable : this.waterDetectables) {
            waterDetectable.detect(this.getWaterAmount());
        }

        for (ISprayable sprayable : this.sprayables) {
            sprayable.spray(this);
        }

        for (IDrainable drainable : this.drainables) {
            drainable.drain(this);
        }

        this.addWater(PLANT_WATER_AMOUNT);
    }
}
