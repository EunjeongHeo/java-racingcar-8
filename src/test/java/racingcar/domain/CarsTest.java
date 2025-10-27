package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 입력된_문자열에서_자동차_리스트를_정상적으로_생성한다() {
        Cars cars = new Cars("pobi,woni,jun");

        List<Car> carList = cars.getCars();

        assertThat(carList).hasSize(3)
                .extracting(Car::name)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 이동_조건을_만족하는_자동차들만_전진한다() {
        Cars cars = new Cars("pobi,woni,jun");

        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);
        cars.getCars().get(2).move(() -> false);

        List<Car> carList = cars.getCars();
        assertThat(carList.get(0).position()).isEqualTo(1);
        assertThat(carList.get(1).position()).isEqualTo(1);
        assertThat(carList.get(2).position()).isEqualTo(0);
    }

    @Test
    void 가장_멀리_간_단일_우승자를_정확히_찾는다() {
        Cars cars = new Cars("pobi,woni,jun");

        // pobi: 3, woni: 2, jun: 1
        moveCarNTimes(cars.getCars().get(0), 3);
        moveCarNTimes(cars.getCars().get(1), 2);
        moveCarNTimes(cars.getCars().get(2), 1);

        List<Car> winners = cars.findWinners();

        assertThat(winners)
                .hasSize(1)
                .extracting(Car::name)
                .containsExactly("pobi");
    }

    @Test
    void 가장_멀리_간_공동_우승자를_정확히_찾는다() {
        Cars cars = new Cars("pobi,woni,jun");

        // pobi: 3, woni: 3, jun: 2
        moveCarNTimes(cars.getCars().get(0), 3);
        moveCarNTimes(cars.getCars().get(1), 3);
        moveCarNTimes(cars.getCars().get(2), 2);

        List<Car> winners = cars.findWinners();

        assertThat(winners)
                .hasSize(2)
                .extracting(Car::name)
                .containsExactly("pobi", "woni");
    }

    private void moveCarNTimes(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.move(() -> true);
        }
    }
}
