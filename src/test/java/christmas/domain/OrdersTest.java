package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @DisplayName("없는 메뉴를 주문하면 예외를 던진다.")
    @Test
    void 없는_메뉴_예외() {
        assertThatThrownBy(() -> new Orders(createOrders("없는메뉴", 1))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴를 1개 미만 주문하면 예외를 던진다.")
    @Test
    void _1개_미만_주문_예외() {
        assertThatThrownBy(() -> new Orders(createOrders("초코케익", 0))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴를 총 20개 초과로 주문하면 예외를 던진다.")
    @Test
    void _20개_초과_주문_예외() {
        assertThatThrownBy(() -> new Orders(createOrders("초코케익", 18))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문하면 예외를 던진다.")
    @Test
    void 음료만_예외() {
        assertThatThrownBy(() -> new Orders(createOrders("샴페인", 18))).isInstanceOf(
                IllegalArgumentException.class);
    }

    private HashMap<String, Integer> createOrders(String name, int count) {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("제로콜라", 3);
        orders.put("샴페인", 4);
        orders.put(name, count);
        return orders;
    }

}