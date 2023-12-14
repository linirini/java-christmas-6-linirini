package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Orders;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WeekAndWeekendDiscountTest {

    private WeekAndWeekendDiscount weekAndWeekendDiscount;

    @BeforeEach
    void init() {
        weekAndWeekendDiscount = new WeekAndWeekendDiscount();
    }

    @DisplayName("주말이면 메인 메뉴에 할인이 적용된다.")
    @ParameterizedTest
    @CsvSource({"2,14161", "8,14161", "23,14161"})
    void 주말_할인(int date, int expected) {
        Orders orders = new Orders(createOrders());
        assertThat(weekAndWeekendDiscount.weekendDiscount(orders, date)).isEqualTo(expected);
    }

    private HashMap<String, Integer> createOrders() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("해산물파스타", 3);
        orders.put("바비큐립", 4);
        orders.put("아이스크림", 5);
        return orders;
    }

}