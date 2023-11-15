package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBenefitTest {

    @DisplayName("총혜택 금액을 반환한다.")
    @Test
    void 총혜택_금액_계산() {
        assertThat(new EventBenefit(1000, 0, 2023, 1000, 25000).getTotalEventBenefit()).isEqualTo(
                29023);
    }

    @DisplayName("총할인 금액을 반환한다.")
    @Test
    void 총할인_금액_계산() {
        assertThat(new EventBenefit(1000, 0, 2023, 1000, 25000).getTotalDiscountAmount()).isEqualTo(
                4023);
    }

}