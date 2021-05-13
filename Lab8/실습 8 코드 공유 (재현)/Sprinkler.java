package academy.pocu.comp2500.lab8;

import java.util.LinkedList;
import java.util.Queue;

public class Sprinkler extends SmartDevice implements ISprayable {
    private static final int SPRAY_AMOUNT_LITER_PER_TICK = 15;

    private final Queue<Schedule> schedules = new LinkedList<>();

    public Sprinkler() {
        super(SmartDeviceType.SPRINKLER);
    }

    public int getSprayAmountLiterPerTick() {
        return SPRAY_AMOUNT_LITER_PER_TICK;
    }

    public void addSchedule(Schedule schedule) {
        assert (schedule != null);

        schedules.add(schedule);
    }

    @Override
    public void spray(Planter planter) {
        assert (planter != null);

        if (isOn()) {
            planter.addWater(this);
        }
    }

    @Override
    protected boolean getNextIsOn(final int nowTick) {
        if (isOn()) {
            Schedule schedule = schedules.peek();

            assert (schedule != null);

            if (nowTick == schedule.getOffTick()) {
                schedules.poll();
                return false;
            }

            return true;
        }

        Schedule schedule = schedules.peek();

        while (schedule != null && (schedule.getOnTick() == 0 || schedule.getOffTick() < nowTick)) {
            schedules.poll();
            schedule = schedules.peek();
        }

        return (schedule != null && schedule.getOnTick() == nowTick);
    }
}
