package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("총 구매 금액을 계산한다.")
    @Test
    void 총구입금액() {
        assertThat(new Orders(createOrders("바비큐립", 2)).getTotalPrice()).isEqualTo(217000);
    }

    @DisplayName("메인 메뉴 개수를 계산한다.")
    @Test
    void 메인_메뉴_개수() {
        assertThat(new Orders(createOrders("바비큐립", 2)).getMainMenusCount()).isEqualTo(2);
    }

    private HashMap<String, Integer> createOrders(String name, int count) {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("제로콜라", 3);
        orders.put("샴페인", 4);
        orders.put(name, count);
        return orders;
    }

}