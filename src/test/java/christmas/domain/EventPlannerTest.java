package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.Gift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventPlannerTest {

    private final static int MINIMUM_ORDER_AMOUNT = 10000;
    private final static int MINIMUM_GIFT_AMOUNT = 120000;

    private EventPlanner eventPlanner;

    @BeforeEach
    void init() {
        eventPlanner = new EventPlanner();
    }

    @DisplayName("이벤트 적용 가능한 최소 금액을 충족하는지 판단한다.")
    @ParameterizedTest
    @ValueSource(ints = {10000, 5000})
    void 이벤트_적용_가능_여부(int amount) {
        assertThat(eventPlanner.isMinimumAmountForEventMet(amount)).isEqualTo(expected(amount));
    }

    @DisplayName("총주문 금액을 기준으로 증정품을 준다.")
    @ParameterizedTest
    @ValueSource(ints = {125000, 10000})
    void 증정품_수여(int amount) {
        assertThat(eventPlanner.presentGift(amount)).isEqualTo(expectedGift(amount));
    }

    private boolean expected(int amount) {
        return amount >= MINIMUM_ORDER_AMOUNT;
    }

    private Gift expectedGift(int amount) {
        if (amount >= MINIMUM_GIFT_AMOUNT) {
            return Gift.GIFT;
        }
        return Gift.NO_GIFT;
    }

}