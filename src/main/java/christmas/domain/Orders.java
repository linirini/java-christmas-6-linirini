package christmas.domain;

import static christmas.domain.menu.MenuGroup.BEVERAGE;
import static christmas.domain.menu.MenuGroup.DESSERT;
import static christmas.domain.menu.MenuGroup.MAIN_DISH;
import static christmas.domain.menu.MenuOption.NONE;
import static christmas.util.ExceptionEnum.NO_MENU;
import static christmas.util.ExceptionEnum.ORDERS_COUNT_EXCESS;
import static christmas.util.ExceptionEnum.ORDERS_ONLY_BEVERAGE;

import christmas.domain.menu.MenuOption;
import java.awt.MenuShortcut;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Orders {

    private static final int MAXIMUM_ORDERS_COUNT = 20;
    private final HashMap<MenuOption, Integer> orders;

    public Orders(HashMap<String, Integer> orders) {
        validate(orders);
        this.orders = createOrders(orders);
    }

    private HashMap<MenuOption, Integer> createOrders(HashMap<String, Integer> orders) {
        return null;
    }

    private void validate(HashMap<String, Integer> orders) {
        throwIfMenuOptionDoesNotExist(orders);
        throwIfOrdersMoreThanMaximum(orders);
        throwIfOrdersOnlyBeverage(orders);
    }

    private void throwIfMenuOptionDoesNotExist(HashMap<String, Integer> orders) {
        for (String menuOption : orders.keySet()) {
            if(MenuOption.hasMenu(menuOption)==NONE){
                throw new IllegalArgumentException(NO_MENU.getMessage());
            }
        }
    }

    private void throwIfOrdersMoreThanMaximum(HashMap<String, Integer> orders) {
        if(getOrdersCount(orders)>MAXIMUM_ORDERS_COUNT){
            throw  new IllegalArgumentException(ORDERS_COUNT_EXCESS.getMessage());
        }
    }

    private int getOrdersCount(HashMap<String, Integer> orders) {
        int count = 0;
        for (String menuOption : orders.keySet()) {
            count += orders.get(menuOption);
        }
        return count;
    }

    private void throwIfOrdersOnlyBeverage(HashMap<String, Integer> orders) {
        for (String menuOption : orders.keySet()) {
            if(MenuOption.valueOf(menuOption).isGroupOf()!=BEVERAGE) {
                return;
            }
        }
        throw new IllegalArgumentException(ORDERS_ONLY_BEVERAGE.getMessage());
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (MenuOption menuOption : orders.keySet()) {
            int menuOptionCount = orders.get(menuOption);
            totalPrice += menuOption.getPrice() * menuOptionCount;
        }
        return totalPrice;
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

    public Map<MenuOption, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }

}
