package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BadgeTest {

    @DisplayName("혜택 금액이 5000원 미만이면 뱃지를 부여받지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {500, 600, 4000})
    void 뱃지_미부여(int amount) {
        assertThat(Badge.getBadge(amount)).isEqualTo(Badge.NONE);
    }

    @DisplayName("혜택 금액이 5000원 이상 10000원 미만이면 별 뱃지를 부여한다.")
    @ParameterizedTest
    @ValueSource(ints = {5000, 6000, 9000})
    void 별_뱃지_부여(int amount) {
        assertThat(Badge.getBadge(amount)).isEqualTo(Badge.STAR);
    }

}