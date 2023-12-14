package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @DisplayName("없는 메뉴를 주문하면 예외를 던진다.")
    @Test
    void 없는_메뉴_예외() {
        assertThatThrownBy(() -> new Orders(createOrders("없는메뉴"))).isInstanceOf(
                IllegalArgumentException.class);
    }

    private HashMap<String, Integer> createOrders(String name) {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("해산물파스타", 3);
        orders.put("바비큐립", 4);
        orders.put(name, 5);
        return orders;
    }

}