package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private static final int PLANT_DRAIN_WATER_AMOUNT = 2;
    private int waterAmount;
    private ArrayList<SmartDevice> smartDevices = new ArrayList<>();
    private ArrayList<ISprayable> sprayables = new ArrayList<>();
    private ArrayList<IDrainable> drainables = new ArrayList<>();
    private ArrayList<IWaterDetectable> waterDetectables = new ArrayList<>();

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void addWater(int waterAmount) {
        this.waterAmount = Math.max(0, waterAmount);
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        smartDevice.installToPlanter(this);
        this.smartDevices.add(smartDevice);
    }

    public void installSprayable(Sprinkler sprayable) {
        this.sprayables.add(sprayable);
    }

    public void installDrainable(IDrainable drainable) {
        this.drainables.add(drainable);
    }

    public void installWaterDetectable(IWaterDetectable waterDetectable) {
        this.waterDetectables.add(waterDetectable);
    }

    public void tick() {
        for (SmartDevice smartDevice : this.smartDevices) {
            smartDevice.onTick();
        }

        for (ISprayable sprayable : this.sprayables) {
            sprayable.spray(this);
        }

        for (IWaterDetectable waterDetectable : this.waterDetectables) {
            waterDetectable.detect(this.waterAmount);
        }

        for (IDrainable drainable : this.drainables) {
            drainable.drain(this);
        }

        this.addWater(PLANT_DRAIN_WATER_AMOUNT);

        /*
        for (Sprinkler sprinkler : this.sprinklers) {
            sprinkler.onTick();
            if (sprinkler.isOn()) {
                this.isSprinklerOn = true;
                this.sprayedWater += 15;
            }
        }

        for (Drainer drainer : this.drainers) {
            drainer.onTick();
            if (drainer.isOn()) {
                this.isDrainerOn = true;
                this.drainedWater += 7;
            }
        }

        this.waterAmount = Math.max(0, this.waterAmount - 2);
        this.isSprinklerOn = false;
        this.isDrainerOn = false;
        this.sprayedWater = 0;
        this.drainedWater = 0;
        */
    }
}
