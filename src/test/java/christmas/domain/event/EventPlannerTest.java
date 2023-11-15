package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import christmas.domain.Orders;
import christmas.domain.menu.MenuOption;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("이벤트 혜택 내역을 계산한다.")
    @Test
    void 이벤트_혜택_내역() {
        //given
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        orders.put(MenuOption.T_BONE_STEAK, 1);
        orders.put(MenuOption.CHOCO_CAKE, 2);

        //when
        EventBenefit eventBenefit = eventPlanner.calculateEventBenefit(25, new Orders(orders),
                Gift.NO_GIFT);

        //then
        assertAll(
                () -> assertThat(eventBenefit.getChristmasDdayBenefit()).isEqualTo(3400),
                () -> assertThat(eventBenefit.getWeekBenefit()).isEqualTo(4046),
                () -> assertThat(eventBenefit.getWeekendBenefit()).isZero(),
                () -> assertThat(eventBenefit.getSpecialBenefit()).isEqualTo(1000),
                () -> assertThat(eventBenefit.getGiftBenefit()).isZero()
        );
    }

    @DisplayName("할인 후 예상 결제 금액을 계산한다..")
    @Test
    void 할인_후_결제_예상_금액() {
        assertThat(eventPlanner.calculateExpectedPayAmount(142000, 6246)).isEqualTo(
                135754);
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