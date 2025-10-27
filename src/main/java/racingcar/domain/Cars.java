package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.InvalidCarNameException;

public class Cars {

    private final List<Car> cars;

    public Cars(String input) {
        List<String> names = parseToList(input);
        validateInputFormat(names);
        this.cars = mapToCars(names);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public void race(MoveStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public List<Car> findWinners() {
        long maxPosition = findMaxPosition();

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.position() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private long findMaxPosition() {
        long max = 0;
        for (Car car : cars) {
            if (car.position() > max) {
                max = car.position();
            }
        }
        return max;
    }

    private List<String> parseToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    private void validateInputFormat(List<String> names) {
        validateInputNotEmpty(names);
        validateInputNoDuplicate(names);
    }

    private void validateInputNotEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new InvalidCarNameException("입력된 값이 없습니다.");
        }
    }

    private void validateInputNoDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name)) {
                throw new InvalidCarNameException("중복해서 입력할 수 없습니다.");
            }
        }
    }

    private List<Car> mapToCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }

}
