package racingcar.domain;

import racingcar.exception.InvalidTryCountException;

public class TryCount {

    private final long value;

    public TryCount(String input) {
        long parsedCount = parseToInt(input);
        validatePositive(parsedCount);
        this.value = parsedCount;
    }

    private long parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidTryCountException("유효하지 않은 숫자 형식이거나 범위를 벗어난 값입니다: " + input);
        }
    }

    private void validatePositive(long value) {
        if (value <= 0) {
            throw new InvalidTryCountException("0 이하의 수는 입력할 수 없습니다: " + value);
        }
    }

    public long value() {
        return value;
    }
}
