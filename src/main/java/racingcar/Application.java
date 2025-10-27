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
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static void run() {
        Cars cars = new Cars(InputView.inputCarNames());
        TryCount tryCount = new TryCount(InputView.inputTryCount());
        MoveStrategy strategy = new RandomMoveStrategy();
        playRacing(cars, tryCount, strategy);
        OutputView.printWinners(cars.findWinners());
    }

    private static void playRacing(Cars cars, TryCount tryCount, MoveStrategy strategy) {
        OutputView.printRaceResultIntro();
        for (long i = 0; i < tryCount.value(); i++) {
            cars.race(strategy);
            OutputView.printEachRoundResult(cars.getCars());
        }
    }
}
