package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private static final int SPRINKLER_SPRAY_WATER_AMOUNT = 15;

    private ArrayList<Integer> startSchedule = new ArrayList<>();
    private ArrayList<Integer> operationSchedule = new ArrayList<>();
    private int endTick;
    private int scheduleCount;

    public Sprinkler() {
        super();
    }

    public void addSchedule(Schedule schedule) {
        this.startSchedule.add(schedule.getStartTick());
        this.operationSchedule.add(schedule.getOperationTick());
    }

    @Override
    public void onTick() {
        ++(super.currentTick);

        setNextScheduleCount();

        /* 더 이상 스케줄이 없을 경우 */
        if (this.scheduleCount >= this.startSchedule.size()) {
            return;
        }

        if (super.currentTick == this.startSchedule.get(this.scheduleCount)) {
            super.stateUpdatedTick = super.currentTick;
            super.isOn = true;

            this.endTick = this.startSchedule.get(this.scheduleCount) + operationSchedule.get(this.scheduleCount);
        }

        if (this.endTick == super.currentTick) {
            super.stateUpdatedTick = super.currentTick;
            super.isOn = false;
        }
    }

    @Override
    public void installToPlanter(Planter planter) {
        planter.installSprayable(this);
    }

    @Override
    public void spray(Planter planter) {
        if (isOn()) {
            planter.addWater(SPRINKLER_SPRAY_WATER_AMOUNT);
        }
    }

    private void setNextScheduleCount() {
        int count;
        int startTick = 0;
        int endTick;

        if (isOn()) {
            return;
        }

        for (count = this.scheduleCount; count < this.startSchedule.size(); ++count) {
            startTick = this.startSchedule.get(count);
            endTick = this.startSchedule.get(count) + this.operationSchedule.get(count);

            if (startTick >= super.currentTick && endTick >= super.currentTick) {
                break;
            }

            if (endTick >= super.currentTick) {
                break;
            }
        }

        if (startTick == 0) {
            ++count;
        }

        this.scheduleCount = count;
    }
}
