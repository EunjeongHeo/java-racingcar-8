package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            Cars cars = InputView.inputCarNames();
            TryCount tryCount = InputView.inputTryCount();
            MoveStrategy strategy = new RandomMoveStrategy();

            OutputView.printRaceResultIntro();

            for (long i = 0; i < tryCount.value(); i++) {
                cars.race(strategy);
                OutputView.printEachRoundResult(cars.getCars());
            }

            OutputView.printWinners(cars.findWinners());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
