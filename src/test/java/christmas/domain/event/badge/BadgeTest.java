package christmas.domain.event.badge;

import static christmas.domain.event.badge.Badge.NO_BADGE;
import static christmas.domain.event.badge.Badge.SANTA;
import static christmas.domain.event.badge.Badge.STAR;
import static christmas.domain.event.badge.Badge.TREE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BadgeTest {

    @DisplayName("혜택 금액에 따라 뱃지를 부여한다..")
    @ValueSource(ints = {3000, 5000, 15000, 23000})
    @ParameterizedTest
    void 뱃지_없음(int amount) {
        assertThat(Badge.determineBadge(amount)).isEqualTo(expectedBadge(amount));
    }

    private Badge expectedBadge(int amount) {
        if (amount >= 20000) {
            return SANTA;
        }
        if (amount >= 10000) {
            return TREE;
        }
        if (amount >= 5000) {
            return STAR;
        }
        return NO_BADGE;
    }

}