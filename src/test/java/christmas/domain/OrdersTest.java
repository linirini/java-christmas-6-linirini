package christmas.domain;

import static christmas.domain.menu.MenuOption.CHAMPAGNE;
import static christmas.domain.menu.MenuOption.MUSHROOM_SOUP;
import static christmas.domain.menu.MenuOption.TAPAS;
import static christmas.domain.menu.MenuOption.ZERO_COKE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.menu.MenuOption;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class OrdersTest {

    @DisplayName("주문 개수가 20개 이상이면 예외를 던진다.")
    @Test
    void 주문_개수_초과() {
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        orders.put(MUSHROOM_SOUP, 15);
        orders.put(TAPAS, 15);
        assertThatThrownBy(() -> new Orders(orders)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 개수가 20개 이하이다.")
    @Test
    void 주문_개수_범위_내() {
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        orders.put(MUSHROOM_SOUP, 5);
        orders.put(TAPAS, 15);
        assertThatNoException().isThrownBy(() -> new Orders(orders));
    }

    @DisplayName("음료만 주문할 경우 예외를 던진다.")
    @Test
    void 음료만_주문(){
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        orders.put(ZERO_COKE, 5);
        orders.put(CHAMPAGNE, 15);
        assertThatThrownBy(()->new Orders(orders)).isInstanceOf(IllegalArgumentException.class);
    }

}
