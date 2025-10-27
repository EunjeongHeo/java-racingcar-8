package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void 숫자_문자열을_올바르게_입력하면_정상적으로_객체를_생성한다() {
        TryCount tryCount = new TryCount("5");

        assertThat(tryCount.value()).isEqualTo(5);
    }

    @Test
    void 음수를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new TryCount("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_0을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new TryCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_문자를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new TryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_범위를_초과한_수를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new TryCount(Long.MAX_VALUE + 1 + ""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
