package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private static final int SPRINKLE_WATER_AMOUNT = 15;

    private final ArrayList<Schedule> schedules = new ArrayList<>();
    private Schedule scheduleOrNull = null;
    private int scheduleNumber = 0;

    public Sprinkler() {
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void installTo(Planter planter) {
        planter.installSprayableDivice(this);
    }

    @Override
    public void onTick() {
        this.tick++;
        this.ticksSinceLastUpdate++;

        // 켜져있고
        if (this.isOn()) {
            // 스케줄이 끝나면
            if (this.tick >= this.scheduleOrNull.getStartTick() + this.scheduleOrNull.getTickCount()) {
                this.isOn = false;
                this.ticksSinceLastUpdate = 0;
                this.scheduleOrNull = null;
            }
            return;
        }

        // 꺼져있는 경우
        // 스케줄이 없으면
        if (this.scheduleOrNull == null) {
            for (int i = this.scheduleNumber; i < this.schedules.size(); ++i) {
                if (this.tick < this.schedules.get(i).getStartTick() + this.schedules.get(i).getTickCount() && this.schedules.get(i).getStartTick() > 0) {
                    this.scheduleOrNull = this.schedules.get(i);
                    this.scheduleNumber = i;
                    break;
                }
            }

            if (this.scheduleOrNull == null) {
                return;
            }
        }


        // 스프링클러 켜기
        if (this.tick == this.scheduleOrNull.getStartTick()) {
            this.isOn = true;
            this.ticksSinceLastUpdate = 0;
        }

        if (this.tick >= this.scheduleOrNull.getStartTick() + this.scheduleOrNull.getTickCount()) {
            this.scheduleOrNull = null;
        }
    }

    @Override
    public void spray(Planter planter) {
        if (this.isOn()) {
            planter.addWater(SPRINKLE_WATER_AMOUNT);
        }
    }
}
