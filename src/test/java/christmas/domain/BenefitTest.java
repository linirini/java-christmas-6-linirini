package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {

    @DisplayName("총혜택 금액을 반환한다.")
    @Test
    void 총혜택_금액() {
        assertThat(createBenefit().getTotalBenefitsPrice()).isEqualTo(31423);
    }

    @DisplayName("증정품 금액을 반환한다.")
    @Test
    void 증정품_금액() {
        assertThat(createBenefit().getGiftEventBenefitPrice()).isEqualTo(25000);
    }

    @DisplayName("증정품을 안 받았을때는 0원을 반환한다.")
    @Test
    void 증정품_미수여_금액() {
        assertThat(
                new Benefit(3400, 2023, 0, 1000, Gift.NONE).getGiftEventBenefitPrice()).isEqualTo(
                0);
    }

    private Benefit createBenefit() {
        return new Benefit(3400, 2023, 0, 1000, Gift.GIFT);
    }

}