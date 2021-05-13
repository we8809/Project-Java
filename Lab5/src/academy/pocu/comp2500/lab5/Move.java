package academy.pocu.comp2500.lab5;

public class Move {
    private String skillName;
    private int skillPower;
    private int skillPowerCount;       /* 본 스킬을 사용할 수 있는 최대 횟수 */
    private final int skillPowerCountMax;

    public Move(String skillName, int skillPower, int skillPowerMax) {
        this.skillName = skillName;
        this.skillPower = skillPower;
        this.skillPowerCount = skillPowerMax;
        this.skillPowerCountMax = skillPowerMax;
    }

    public String getSkillName() {
        return this.skillName;
    }

    public int getSkillPower() {
        return this.skillPower;
    }

    public int getSkillPowerMax() {
        return this.skillPowerCount;
    }

    public void consumeSkillPower() {
        this.skillPowerCount -= 1;
    }

    public void recoverSkillPower() {
        if (this.skillPowerCount == this.skillPowerCountMax) {
            return;
        }

        this.skillPowerCount += 1;
    }
}
