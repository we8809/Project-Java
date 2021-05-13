package academy.pocu.comp2500.lab5;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Gladiator extends Barbarian {
    private LinkedHashMap<String, Move> moveSkills;

    public Gladiator(String name, int hp, int offense, int defense) {
        super(name, hp, offense, defense);
        this.moveSkills = new LinkedHashMap<String, Move>();
    }

    public boolean addMove(Move moveSkill) {
        if (this.moveSkills.containsKey(moveSkill.getSkillName()) || this.moveSkills.size() == 4) {
            return false;
        }

        this.moveSkills.put(moveSkill.getSkillName(), moveSkill);
        return true;
    }

    public boolean removeMove(String moveSkillName) {
        if (!this.moveSkills.containsKey(moveSkillName)) {
            return false;
        }

        this.moveSkills.remove(moveSkillName);
        return true;
    }

    public void attack(String moveSkillName, Barbarian otherGladiator) {
        if (!isAlive()) {
            return;
        }

        if (this.name.equals(otherGladiator.name)) {
            return;
        }

        Move moveSkill = this.moveSkills.get(moveSkillName);
        if (moveSkill == null) {
            return;
        }

        if (moveSkill.getSkillPowerMax() == 0) {
            return;
        }

        if (!otherGladiator.isAlive()) {
            return;
        }

        double damage = (double) this.offense / (double) otherGladiator.defense * (double) moveSkill.getSkillPower() / 2.0;
        moveSkill.consumeSkillPower();
        otherGladiator.hp -= (damage < 1.0) ? 1 : Math.min(otherGladiator.hp, (int) damage);
    }

    public void rest() {
        this.hp += (this.maxHp <= this.hp + 10) ? (this.maxHp - this.hp) : 10;

        Iterator<String> skillNameIterator = this.moveSkills.keySet().iterator();
        for (int i = 0; i < this.moveSkills.size(); i++) {
            String skillName = skillNameIterator.next();

            Move moveSkill = this.moveSkills.get(skillName);
            moveSkill.recoverSkillPower();
        }
    }
}
