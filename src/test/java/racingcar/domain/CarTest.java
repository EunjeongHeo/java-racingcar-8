package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 이름과_초기_위치를_정상적으로_생성한다() {
        Car car = new Car("pobi");

        assertThat(car.name()).isEqualTo("pobi");
        assertThat(car.position()).isZero();
    }

    @Test
    void 이동_조건을_만족하면_전진한다() {
        Car car = new Car("pobi");

        car.move(() -> true);

        assertThat(car.position()).isEqualTo(1);
    }

    @Test
    void 이동_조건을_만족하지_못하면_정지한다() {
        Car car = new Car("pobi");

        car.move(() -> false);

        assertThat(car.position()).isZero();
    }
}

