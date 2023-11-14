package christmas.domain;

import static christmas.domain.menu.MenuType.BEVERAGE;
import static christmas.util.ExceptionEnum.MAXIMUM_ORDER_COUNT_EXCEEDED;
import static christmas.util.ExceptionEnum.ORDERS_ONLY_BEVERAGE;

import christmas.domain.menu.MenuOption;
import christmas.domain.menu.MenuType;
import java.util.HashMap;
import java.util.Map.Entry;

public class Orders {

    private final HashMap<MenuOption, Integer> orders;


    public Orders(HashMap<MenuOption, Integer> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(HashMap<MenuOption, Integer> orders) {
        throwIfMaximumOrderCountExceeded(orders);
        throwIfOrdersOnlyBeverage(orders);
    }

    private void throwIfMaximumOrderCountExceeded(HashMap<MenuOption, Integer> menusAndCount) {
        int totalCount = 0;
        for (Integer count : menusAndCount.values()) {
            totalCount += count;
        }
        if (totalCount > 20) {
            throw new IllegalArgumentException(MAXIMUM_ORDER_COUNT_EXCEEDED.getMessage());
        }
    }

    private void throwIfOrdersOnlyBeverage(HashMap<MenuOption, Integer> orders) {
        for (MenuOption menuOption : orders.keySet()) {
            if (MenuType.findMenuType(menuOption.getViewName()) != BEVERAGE) {
                return;
            }
        }
        throw new IllegalArgumentException(ORDERS_ONLY_BEVERAGE.getMessage());
    }

    public HashMap<String, Integer> getOrderedMenusAndCount() {
        HashMap<String, Integer> orderedMenusAndCount = new HashMap<>();
        for (Entry<MenuOption, Integer> entry : orders.entrySet()) {
            orderedMenusAndCount.put(entry.getKey().getViewName(), entry.getValue());
        }
        return orderedMenusAndCount;
    }

    public int getTotalOrderAmount(){
        int amount = 0;
        for (Entry<MenuOption, Integer> entry : orders.entrySet()) {
            amount +=entry.getKey().getPrice()*entry.getValue();
        }
        return amount;
    }

}
