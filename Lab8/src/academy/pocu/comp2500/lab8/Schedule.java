package academy.pocu.comp2500.lab8;

public class Schedule {
    private final int startTick;
    private final int operationTick;

    public Schedule(int startTick, int operationTick) {
        assert (startTick >= 0);
        assert (operationTick > 0);

        this.startTick = startTick;
        this.operationTick = operationTick;
    }

    public int getStartTick() {
        return this.startTick;
    }

    public int getOperationTick() {
        return this.operationTick;
    }
}
