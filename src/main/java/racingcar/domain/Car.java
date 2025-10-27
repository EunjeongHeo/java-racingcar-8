package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public Car(String name) {
        validateNameRule(name);
        this.name = name;
    }

    private void validateNameRule(String name) {
        validateNotBlank(name);
        validateLength(name);
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
