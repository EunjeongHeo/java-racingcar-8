package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveStrategy {

    private static final int MOVABLE_THRESHOLD = 4;

    public boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= MOVABLE_THRESHOLD;
    }
}
