package christmas.domain.event.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasDdayDiscountTest {

    private ChristmasDdayDiscount christmasDdayDiscount;

    @BeforeEach
    void init() {
        christmasDdayDiscount = new ChristmasDdayDiscount();
    }

    @DisplayName("크리스마스 할인 금액을 구한다.")
    @ValueSource(ints = {1, 20, 25})
    @ParameterizedTest
    void 크리스마스_할인_금액_적용(int date) {
        assertThat(christmasDdayDiscount.discount(date)).isEqualTo(1000 + 100 * (date - 1));
    }

    @DisplayName("크리스마스 할인이 적용되지 않는다.")
    @ValueSource(ints = {26, 31})
    @ParameterizedTest
    void 크리스마스_할인_금액_미적용(int date) {
        assertThat(christmasDdayDiscount.discount(date)).isEqualTo(0);
    }

}