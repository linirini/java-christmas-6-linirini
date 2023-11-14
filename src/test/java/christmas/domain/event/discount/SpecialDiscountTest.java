package christmas.domain.event.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountTest {

    private SpecialDiscount specialDiscount;

    @BeforeEach
    void init() {
        specialDiscount = new SpecialDiscount();
    }

    @DisplayName("특별 할인 날짜면 1000원 할인된다.")
    @Test
    void 특별_할인_적용() {
        assertThat(specialDiscount.discount(24)).isEqualTo(1000);
    }

    @DisplayName("특별 할인 날짜가 아니면 할인은 없다.")
    @Test
    void 특별_할인_미적용() {
        assertThat(specialDiscount.discount(23)).isEqualTo(0);
    }

}