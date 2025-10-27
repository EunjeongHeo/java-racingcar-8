package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 이름이_빈값이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5자를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("toolongname"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_0자이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

