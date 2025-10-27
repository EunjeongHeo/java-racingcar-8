package racingcar.domain;

import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = List.copyOf(winners);
    }

    public String getNames() {
        return winners.stream()
                .map(Car::name)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");
    }

    public List<Car> getCars() {
        return List.copyOf(winners);
    }
}
