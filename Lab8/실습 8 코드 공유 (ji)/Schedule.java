package academy.pocu.comp2500.lab8;

public class Schedule {
    private final int startTick;
    private final int tickCount;

    public Schedule(int startTick, int tickCount) {
        this.startTick = startTick;
        this.tickCount = tickCount;
    }

    public int getStartTick() {
        return startTick;
    }

    public int getTickCount() {
        return tickCount;
    }
}

