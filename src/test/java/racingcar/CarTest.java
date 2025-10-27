package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.exception.InvalidCarNameException;

public class CarTest {

    @Test
    void 자동차는_무작위_값이_4이상이면_전진한다() {
        Car car = new Car("pobi");
        car.move(() -> true);

        assertThat(car.position()).isEqualTo(1);
    }

    @Test
    void 자동차는_무작위_값이_4미만이면_정지한다() {
        Car car = new Car("pobi");
        car.move(() -> false);

        assertThat(car.position()).isEqualTo(0);
    }

    @Test
    void 이름이_5자를_초과하면_예외를_던진다() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(InvalidCarNameException.class);
    }

    @Test
    void 이름이_비어있으면_예외를_던진다() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(InvalidCarNameException.class);
    }
}

