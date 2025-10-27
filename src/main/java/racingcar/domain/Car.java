package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;
    private long position = 0;

    public Car(String name) {
        validateNameRule(name);
        this.name = name;
    }

    private void validateNameRule(String name) {
        validateNotBlank(name);
        validateLength(name);
    }

    public void move(MoveStrategy strategy) {
        if (strategy.isMovable()) {
            position++;
        }
    }

    public String name() {
        return name;
    }

    public long position() {
        return position;
    }

    private void validateNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidCarNameException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        int length = name.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new InvalidCarNameException("자동차 이름은 1자 이상, 5자 이하만 가능합니다: " + name);
        }
    }
}
