package christmas.domain;

import static christmas.domain.menu.MenuOption.CHAMPAGNE;
import static christmas.domain.menu.MenuOption.CHOCO_CAKE;
import static christmas.domain.menu.MenuOption.ICE_CREAM;
import static christmas.domain.menu.MenuOption.MUSHROOM_SOUP;
import static christmas.domain.menu.MenuOption.SEAFOOD_PASTA;
import static christmas.domain.menu.MenuOption.TAPAS;
import static christmas.domain.menu.MenuOption.T_BONE_STEAK;
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
        HashMap<MenuOption, Integer> orders = createTwoOrders(MUSHROOM_SOUP, 15, TAPAS, 15);
        assertThatThrownBy(() -> new Orders(orders)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 개수가 20개 이하이다.")
    @Test
    void 주문_개수_범위_내() {
        HashMap<MenuOption, Integer> orders = createTwoOrders(MUSHROOM_SOUP, 5, TAPAS, 15);
        assertThatNoException().isThrownBy(() -> new Orders(orders));
    }

    @DisplayName("음료만 주문할 경우 예외를 던진다.")
    @Test
    void 음료만_주문() {
        HashMap<MenuOption, Integer> orders = createTwoOrders(ZERO_COKE, 5, CHAMPAGNE, 15);
        assertThatThrownBy(() -> new Orders(orders)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴명과 개수를 반환한다.")
    @Test
    void 주문_메뉴명과_개수_반환() {
        HashMap<MenuOption, Integer> orders = createTwoOrders(ZERO_COKE, 5, TAPAS, 15);
        Orders result = new Orders(orders);
        assertThat(result.getOrderedMenusAndCount()).hasSize(2)
                .contains(entry("제로콜라", 5), entry("타파스", 15));
    }

    @DisplayName("할인 전 총주문 금액을 반환한다.")
    @Test
    void 할인_전_총주문_금액() {
        HashMap<MenuOption, Integer> orders = createTwoOrders(MUSHROOM_SOUP, 5, TAPAS, 15);
        Orders result = new Orders(orders);
        assertThat(result.getTotalOrderAmount()).isEqualTo(112500);
    }

    @DisplayName("주문한 메인 메뉴 개수를 반환한다.")
    @Test
    void 주문한_메인_메뉴_개수() {
        HashMap<MenuOption, Integer> orders = createThreeOrders(T_BONE_STEAK, 5, ZERO_COKE, 12,
                SEAFOOD_PASTA, 2);
        Orders result = new Orders(orders);
        assertThat(result.getMainDishCount()).isEqualTo(7);
    }

    @DisplayName("주문한 디저트 메뉴 개수를 반환한다.")
    @Test
    void 주문한_디저트_메뉴_개수() {
        HashMap<MenuOption, Integer> orders = createThreeOrders(CHOCO_CAKE, 15, ZERO_COKE, 1,
                ICE_CREAM, 1);
        Orders result = new Orders(orders);
        assertThat(result.getDessertCount()).isEqualTo(16);
    }

    private HashMap<MenuOption, Integer> createTwoOrders(MenuOption option1, int quantity1,
            MenuOption option2, int quantity2) {
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        orders.put(option1, quantity1);
        orders.put(option2, quantity2);
        return orders;
    }

    private HashMap<MenuOption, Integer> createThreeOrders(MenuOption option1, int quantity1,
            MenuOption option2, int quantity2, MenuOption option3, int quantity3) {
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        orders.put(option1, quantity1);
        orders.put(option2, quantity2);
        orders.put(option3, quantity3);
        return orders;
    }

}
