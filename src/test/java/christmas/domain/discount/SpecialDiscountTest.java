package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SpecialDiscountTest {

    private SpecialDiscount specialDiscount;

    @BeforeEach
    void init() {
        specialDiscount = new SpecialDiscount();
    }

    @DisplayName("달력이 별이 표시되어 있으면 특별 할인이 적용된다.")
    @ParameterizedTest
    @CsvSource({"31,1000", "25,1000", "3,1000"})
    void 특별_할인_적용(int date, int expected) {
        assertThat(specialDiscount.discount(date)).isEqualTo(expected);
    }

}