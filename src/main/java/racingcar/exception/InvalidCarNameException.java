package racingcar.exception;

public class InvalidCarNameException extends IllegalArgumentException {
    public InvalidCarNameException(String message) {
        super("자동차 이름이 올바르지 않습니다. " + message);
    }
}
