package christmas.domain;

import static christmas.domain.menu.MenuGroup.BEVERAGE;
import static christmas.domain.menu.MenuGroup.DESSERT;
import static christmas.domain.menu.MenuGroup.MAIN_DISH;
import static christmas.domain.menu.MenuOption.NONE;
import static christmas.util.ExceptionEnum.INVALID_ORDER;
import static christmas.util.ExceptionEnum.ORDERS_COUNT_EXCESS;
import static christmas.util.ExceptionEnum.ORDERS_ONLY_BEVERAGE;

import christmas.domain.menu.MenuOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Orders {

    private static final int MINIMUM_ORDER_COUNT = 1;
    private static final int MAXIMUM_ORDERS_COUNT = 20;
    private final HashMap<MenuOption, Integer> orders;

    public Orders(HashMap<String, Integer> orders) {
        validate(orders);
        this.orders = createOrders(orders);
    }

    private HashMap<MenuOption, Integer> createOrders(HashMap<String, Integer> ordersToConvert) {
        HashMap<MenuOption,Integer> orders = new HashMap<>();
        for (Entry<String, Integer> entry : ordersToConvert.entrySet()) {
            orders.put(MenuOption.findMenuOption(entry.getKey()),entry.getValue());
        }
        return orders;
    }

    private void validate(HashMap<String, Integer> orders) {
        throwIfMenuOptionDoesNotExist(orders);
        throwIfInvalidMenuOptionCount(orders);
        throwIfOrdersMoreThanMaximum(orders);
        throwIfOrdersOnlyBeverage(orders);
    }

    private void throwIfMenuOptionDoesNotExist(HashMap<String, Integer> orders) {
        for (String menuOption : orders.keySet()) {
            if(MenuOption.findMenuOption(menuOption)==NONE){
                throw new IllegalArgumentException(INVALID_ORDER.getMessage());
            }
        }
    }

    private void throwIfInvalidMenuOptionCount(HashMap<String, Integer> orders) {
        for (String menuOption : orders.keySet()) {
            if(orders.get(menuOption)<MINIMUM_ORDER_COUNT){
                throw new IllegalArgumentException(INVALID_ORDER.getMessage());
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
            if(MenuOption.findMenuOption(menuOption).isGroupOf()!=BEVERAGE) {
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
