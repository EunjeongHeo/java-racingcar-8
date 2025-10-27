package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void 숫자_문자열을_올바르게_입력하면_정상적으로_객체를_생성한다() {
        TryCount tryCount = new TryCount("5");

        assertThat(tryCount.value()).isEqualTo(5);
    }

}
