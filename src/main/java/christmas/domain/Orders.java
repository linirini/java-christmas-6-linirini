package christmas.domain;

import static christmas.domain.menu.MenuGroup.DESSERT;
import static christmas.domain.menu.MenuGroup.MAIN_DISH;

import christmas.domain.menu.MenuOption;
import java.util.HashMap;
import java.util.Map.Entry;

public class Orders {

    private final HashMap<MenuOption, Integer> orders;

    public Orders(HashMap<MenuOption, Integer> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(HashMap<MenuOption, Integer> orders) {
    }

    public int getTotalPrice() {
        return -1;
    }

    public int getOrdersCount() {
        return -1;
    }

    public int getMainMenusCount() {
        int count = 0;
        for (Entry<MenuOption, Integer> entry : orders.entrySet()) {
            if (entry.getKey().isGroupOf() == MAIN_DISH) {
                count += entry.getValue();
            }
        }
        return count;
    }

    public int getDessertMenusCount() {
        int count = 0;
        for (Entry<MenuOption, Integer> entry : orders.entrySet()) {
            if (entry.getKey().isGroupOf() == DESSERT) {
                count += entry.getValue();
            }
        }
        return count;
    }

}
