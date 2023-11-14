package christmas.util;

import static christmas.util.DecemberCalender.hasStar;
import static christmas.util.DecemberCalender.isAfterChristmas;
import static christmas.util.DecemberCalender.isValidDate;
import static christmas.util.DecemberCalender.isWeekend;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DecemberCalenderTest {

    @DisplayName("이벤트 기간에 포함된다.")
    @ParameterizedTest
    @ValueSource(ints = {23, 31})
    void 이벤트_기간_포함(int date) {
        assertThat(isValidDate(date)).isTrue();
    }

    @DisplayName("이벤트 기간에 포함되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {32, 34})
    void 이벤트_기간_미포함(int date) {
        assertThat(isValidDate(date)).isFalse();
    }

    @DisplayName("크리스마스 전이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 25})
    void 크리스마스_전(int date) {
        assertThat(isAfterChristmas(date)).isFalse();
    }

    @DisplayName("크리스마스 이후다.")
    @ParameterizedTest
    @ValueSource(ints = {26, 29})
    void 크리스마스_후(int date) {
        assertThat(isAfterChristmas(date)).isTrue();
    }

    @DisplayName("평일이다.")
    @ParameterizedTest
    @ValueSource(ints = {18, 31})
    void 평일(int date) {
        assertThat(isWeekend(date)).isFalse();
    }

    @DisplayName("주말이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 22})
    void 주말(int date) {
        assertThat(isWeekend(date)).isTrue();
    }

    @DisplayName("별표 된 날짜이다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 25})
    void 별표_날짜(int date) {
        assertThat(hasStar(date)).isTrue();
    }

    @DisplayName("별표 없는 날짜이다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 26})
    void 별표_없는_날짜(int date) {
        assertThat(hasStar(date)).isFalse();
    }

}