package academy.pocu.comp2500.lab8;

public class Schedule {
    private final int onTick;
    private final int offTick;

    public Schedule(int onTick, int durationTick) {
        assert (onTick >= 0);
        assert (durationTick > 0);

        this.onTick = onTick;
        this.offTick = onTick + durationTick;
    }

    public int getOnTick() {
        return onTick;
    }

    public int getOffTick() {
        return offTick;
    }
}
