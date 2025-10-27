package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVABLE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= MOVABLE_THRESHOLD;
    }
}
