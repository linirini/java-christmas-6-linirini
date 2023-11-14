package christmas.domain;

import static christmas.domain.menu.MenuOption.CHAMPAGNE;
import static christmas.domain.menu.MenuOption.MUSHROOM_SOUP;
import static christmas.domain.menu.MenuOption.TAPAS;
import static christmas.domain.menu.MenuOption.ZERO_COKE;
import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.menu.MenuOption;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrdersTest {

    @DisplayName("주문 개수가 20개 이상이면 예외를 던진다.")
    @Test
    void 주문_개수_초과() {
        HashMap<MenuOption, Integer> orders = createOrders(MUSHROOM_SOUP, 15, TAPAS, 15);
        assertThatThrownBy(() -> new Orders(orders)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 개수가 20개 이하이다.")
    @Test
    void 주문_개수_범위_내() {
        HashMap<MenuOption, Integer> orders = createOrders(MUSHROOM_SOUP, 5, TAPAS, 15);
        assertThatNoException().isThrownBy(() -> new Orders(orders));
    }

    @DisplayName("음료만 주문할 경우 예외를 던진다.")
    @Test
    void 음료만_주문() {
        HashMap<MenuOption, Integer> orders = createOrders(ZERO_COKE, 5, CHAMPAGNE, 15);
        assertThatThrownBy(() -> new Orders(orders)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴명과 개수를 반환한다.")
    @Test
    void 주문_메뉴명과_개수_반환() {
        HashMap<MenuOption, Integer> orders = createOrders(ZERO_COKE, 5, TAPAS, 15);
        Orders result = new Orders(orders);
        assertThat(result.getOrderedMenusAndCount()).hasSize(2)
                .contains(entry("제로콜라", 5), entry("타파스", 15));
    }

    @DisplayName("할인 전 총주문 금액을 반환한다.")
    @Test
    void 할인_전_총주문_금액() {
        HashMap<MenuOption, Integer> orders = createOrders(MUSHROOM_SOUP, 5, TAPAS, 15);
        Orders result = new Orders(orders);
        assertThat(result.getTotalOrderAmount()).isEqualTo(112500);
    }

    private HashMap<MenuOption, Integer> createOrders(MenuOption option1, int quantity1,
            MenuOption option2, int quantity2) {
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        orders.put(option1, quantity1);
        orders.put(option2, quantity2);
        return orders;
    }

}
