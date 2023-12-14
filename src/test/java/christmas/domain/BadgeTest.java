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

    @DisplayName("혜택 금액이 10000원 이상 20000원 미만이면 트리 뱃지를 부여한다.")
    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 16000, 19000})
    void 트리_뱃지_부여(int amount) {
        assertThat(Badge.getBadge(amount)).isEqualTo(Badge.TREE);
    }

    @DisplayName("혜택 금액이 20000원 이상이면 산타 뱃지를 부여한다.")
    @ParameterizedTest
    @ValueSource(ints = {20000, 25000, 300000})
    void 산타_뱃지_부여(int amount) {
        assertThat(Badge.getBadge(amount)).isEqualTo(Badge.SANTA);
    }

}