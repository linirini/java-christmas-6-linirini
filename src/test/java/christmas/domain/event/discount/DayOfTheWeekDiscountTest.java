package christmas.domain.event.discount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import christmas.domain.Orders;
import christmas.domain.menu.MenuOption;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayOfTheWeekDiscountTest {

    private DayOfTheWeekDiscount dayOfTheWeekDiscount;

    @BeforeEach
    void init() {
        dayOfTheWeekDiscount = new DayOfTheWeekDiscount();
    }

    @DisplayName("평일에는 디저트 메뉴에 할인이 적용된다.")
    @Test
    void 평일_할인_적용() {
        //given
        Orders orders = createOrders();
        int date = 25;

        //when
        int weekDiscount = dayOfTheWeekDiscount.weekDiscount(date, orders);
        int weekendDiscount = dayOfTheWeekDiscount.weekendDiscount(date, orders);

        //then
        assertAll(() -> assertThat(weekDiscount).isEqualTo(2023),
                () -> assertThat(weekendDiscount).isZero());
    }

    @DisplayName("주말에는 디저트 메뉴에 할인이 적용된다.")
    @Test
    void 주말_할인_적용() {
        //given
        Orders orders = createOrders();
        int date = 16;

        //when
        int weekDiscount = dayOfTheWeekDiscount.weekDiscount(date, orders);
        int weekendDiscount = dayOfTheWeekDiscount.weekendDiscount(date, orders);

        //then
        assertAll(() -> assertThat(weekDiscount).isZero(),
                () -> assertThat(weekendDiscount).isEqualTo(4046));
    }

    private Orders createOrders() {
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        orders.put(MenuOption.T_BONE_STEAK, 2);
        orders.put(MenuOption.CHOCO_CAKE, 1);
        return new Orders(orders);
    }

}