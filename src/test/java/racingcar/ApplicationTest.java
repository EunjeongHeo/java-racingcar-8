package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경주_정상_진행_후_단일_우승자_출력() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni,jun", "3");

            assertThat(output())
                    .contains("실행 결과")
                    .contains("최종 우승자 : pobi")
                    .contains("pobi : ---")
                    .contains("woni :")
                    .contains("jun :");
        }, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP);
    }

    @Test
    void 경주_정상_진행_후_공동_우승자_출력() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "2");

            assertThat(output())
                    .contains("최종 우승자 : pobi, woni");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 자동차_이름에_아무것도_입력하지_않으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름에_하나라도_빈값을_입력하면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_음수를_입력하면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_입력_범위를_초과한_수를_입력하면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", Long.MAX_VALUE + 1 + ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
