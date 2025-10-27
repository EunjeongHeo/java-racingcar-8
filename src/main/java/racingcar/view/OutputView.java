package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Winners;

public class OutputView {

    public static void printRaceResultIntro() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printEachRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.name() + " : " + "-".repeat((int) car.position()));
        }
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        System.out.println("최종 우승자 : " + winners.getNames());
    }
}
