package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private static final int DRAIN_WATER_AMOUNT = -7;
    private final int activeWaterLevel;

    public Drainer(int activeWaterLevel) {
        super();
        this.activeWaterLevel = activeWaterLevel;
    }

    @Override
    public void installToPlanter(Planter planter) {
        planter.installDrainable(this);
        planter.installWaterDetectable(this);
    }

    @Override
    public void onTick() {
        ++(super.currentTick);
        ++(super.stateUpdatedTick);

        /*
        if (super.planter == null) {
            return;
        }

        detect(this.waterLevel);

        if (isOn()) {
            drain(super.planter);
        }
        */
    }

    @Override
    public void drain(Planter planter) {
        if (isOn()) {
            planter.addWater(DRAIN_WATER_AMOUNT);
        }
    }

    @Override
    public void detect(final int waterLevel) {
        if (isOn() != (this.activeWaterLevel <= waterLevel)) {
            super.isOn = !super.isOn;
            super.stateUpdatedTick = 0;
        }

        /*
        int remainingWaterAmount = super.planter.getWaterAmount();

        if (super.planter.isSprinklerOn()) {
            remainingWaterAmount -= super.planter.getSprayedWater();
        }

        if (super.planter.isDrainerOn()) {
            remainingWaterAmount += super.planter.getDrainedWater();
        }

        if (this.waterLevel <= remainingWaterAmount) {
            if (!isOn()) {
                super.stateUpdatedTick = super.currentTick;
            }

            super.isDeviceOn = true;
        } else {
            if (isOn()) {
                super.stateUpdatedTick = super.currentTick;
            }

            super.isDeviceOn = false;
        }
        */
    }
}
