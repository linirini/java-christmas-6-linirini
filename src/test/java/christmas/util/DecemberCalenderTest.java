package christmas.util;

import static christmas.util.DecemberCalender.isAfterChristmas;
import static christmas.util.DecemberCalender.isValidDate;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DecemberCalenderTest {

    @DisplayName("이벤트 기간에 포함된다.")
    @ParameterizedTest
    @ValueSource(ints={23,31})
    void 이벤트_기간_포함(int date) {
        assertThat(isValidDate(date)).isTrue();
    }

    @DisplayName("이벤트 기간에 포함되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints={32,34})
    void 이벤트_기간_미포함(int date) {
        assertThat(isValidDate(date)).isFalse();
    }

    @DisplayName("크리스마스 전이다.")
    @ParameterizedTest
    @ValueSource(ints={1,3,25})
    void 크리스마스_전(int date){
        assertThat(isAfterChristmas(date)).isFalse();
    }

}