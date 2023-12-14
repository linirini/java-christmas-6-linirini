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

    private Benefit createBenefit() {
        return new Benefit(3400, 2023, 0, 1000, Gift.GIFT);
    }

}