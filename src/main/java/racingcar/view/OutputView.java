package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

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

    public static void printWinners(List<Car> winners) {
        String names = winners.stream()
                .map(Car::name)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + names);
    }
}
