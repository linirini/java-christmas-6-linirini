package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GiftTest {

    @DisplayName("12만원 이상 구매 시 증정품을 받는다.")
    @ParameterizedTest
    @ValueSource(ints = {120000, 200000, 1000000})
    void 증정훔_수령(int amount) {
        assertThat(Gift.receiveGift(amount)).isEqualTo(Gift.GIFT);
    }

}