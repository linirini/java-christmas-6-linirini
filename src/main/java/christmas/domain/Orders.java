package christmas.domain;

import static christmas.domain.menu.MenuGroup.BEVERAGE;
import static christmas.domain.menu.MenuGroup.DESSERT;
import static christmas.domain.menu.MenuGroup.MAIN_DISH;
import static christmas.util.ExceptionEnum.ORDERS_COUNT_EXCESS;
import static christmas.util.ExceptionEnum.ORDERS_ONLY_BEVERAGE;

import christmas.domain.menu.MenuOption;
import java.util.HashMap;
import java.util.Map.Entry;

public class Orders {

    private static final int MAXIMUM_ORDERS_COUNT = 20;
    private final HashMap<MenuOption, Integer> orders;

    public Orders(HashMap<MenuOption, Integer> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(HashMap<MenuOption, Integer> orders) {
        throwIfOrdersMoreThanMaximum(orders);
        throwIfOrdersOnlyBeverage(orders);
    }

    private void throwIfOrdersMoreThanMaximum(HashMap<MenuOption, Integer> orders) {
        if(getOrdersCount(orders)>MAXIMUM_ORDERS_COUNT){
            throw  new IllegalArgumentException(ORDERS_COUNT_EXCESS.getMessage());
        }
    }

    private int getOrdersCount(HashMap<MenuOption, Integer> orders) {
        int count = 0;
        for (MenuOption menuOption : orders.keySet()) {
            count += orders.get(menuOption);
        }
        return count;
    }

    private void throwIfOrdersOnlyBeverage(HashMap<MenuOption, Integer> orders) {
        for (MenuOption menuOption : orders.keySet()) {
            if(menuOption.isGroupOf()!=BEVERAGE) {
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

}
