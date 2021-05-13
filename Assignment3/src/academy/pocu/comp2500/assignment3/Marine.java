package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class Marine extends Unit implements IMovable, IThinkable {
    public Marine(IntVector2D position) {
        super(UnitType.GROUND,35, 2, 0, 6, UnitType.UNIFY, position);
    }

    @Override
    public AttackIntent attack() {
        return super.attackIntent;
    }

    @Override
    public void onSpawn() {
        super.simulationManager = SimulationManager.getInstance();
        super.simulationManager.registerMovable(this);
        super.simulationManager.registerThinkable(this);
    }

    @Override
    public char getSymbol() {
        return 'M';
    }

    @Override
    public void move() {

    }

    @Override
    public void think() {
        Unit targetOfAttack = null;

        int x = super.getPosition().getX();
        int y = super.getPosition().getY();

        int scanX = Math.max(0, x - 2);
        int scanY = Math.max(0, y - 2);

        /* 우선순위 1 : 가장 약한 유닛(HP가 가장 낮은 유닛)이 있는 타일 공격 */
        for (int i = scanX; i < 5; ++i) {
            for (int j = scanY; j < 5; ++j) {
                ArrayList<Unit> unitsFromPosition = super.simulationManager.getUnitsFromPosition(i, j);

                if (unitsFromPosition.size() == 0) {
                    continue;
                }

                for (Unit unit : unitsFromPosition) {
                    if (this == unit) {
                        continue;
                    }

                    if (targetOfAttack == null) {
                        targetOfAttack = unit;
                    } else {
                        if (unit.getHp() < targetOfAttack.getHp()) {
                            targetOfAttack = unit;
                        }
                    }
                }
            }
        }

        if (targetOfAttack != null) {
            AttackIntent attackIntent = this.attack();
            targetOfAttack.onAttacked(attackIntent.getDamage());
            return;
        }

        /*
            우선 순위 2 : 자신의 위치의 유닛이 있다면 그 타일을 공격.
            그렇지 않을 경우 북쪽(위쪽)에 있다면 그 타일을 공격. 그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격
         */
    }
}
