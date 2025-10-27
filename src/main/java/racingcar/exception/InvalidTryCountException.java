package racingcar.exception;

public class InvalidTryCountException extends IllegalArgumentException {
    public InvalidTryCountException(String message) {
        super("이동 횟수가 올바르지 않습니다. " + message);
    }
}
