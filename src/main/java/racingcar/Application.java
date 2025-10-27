package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            Cars cars = InputView.inputCarNames();
            TryCount tryCount = InputView.inputTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
