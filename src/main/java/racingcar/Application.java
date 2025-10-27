package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            Cars cars = InputView.inputCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
