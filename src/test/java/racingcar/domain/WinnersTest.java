package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    void 단일_우승자_이름을_정확히_반환한다() {
        Car car1 = new Car("pobi");
        Winners winners = new Winners(List.of(car1));

        assertThat(winners.getNames()).isEqualTo("pobi");
    }

    @Test
    void 공동_우승자_이름을_쉼표로_구분하여_정확히_반환한다() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Winners winners = new Winners(List.of(car1, car2));

        assertThat(winners.getNames()).isEqualTo("pobi, woni");
    }
}

