package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChristmasDdayDiscountTest {

    private ChristmasDdayDiscount christmasDdayDiscount;

    @BeforeEach
    void init() {
        christmasDdayDiscount = new ChristmasDdayDiscount();
    }

    @DisplayName("크리스마스 디데이 할인 이벤트 기간이면 할인이 적용된다.")
    @ParameterizedTest
    @CsvSource({"1,1000", "15,2400", "25,3400"})
    void 크리스마스_디데이_할인_적용(int date, int expected) {
        assertThat(christmasDdayDiscount.discount(date)).isEqualTo(expected);
    }

}