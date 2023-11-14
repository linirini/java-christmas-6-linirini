package christmas.util;

import static christmas.util.DecemberCalender.isValidDate;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecemberCalenderTest {

    @DisplayName("이벤트 기간에 포함된다.")
    @Test
    void 이벤트_기간_포함() {
        int date = 31;
        assertThat(isValidDate(date)).isTrue();
    }

    @DisplayName("이벤트 기간에 포함되지 않는다.")
    @Test
    void 이벤트_기간_미포함() {
        int date = 34;
        assertThat(isValidDate(date)).isFalse();
    }

}