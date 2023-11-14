package christmas.domain;

import static christmas.util.ExceptionEnum.MAXIMUM_ORDER_COUNT_EXCEEDED;

import christmas.domain.menu.MenuOption;
import java.util.HashMap;

public class Orders {

    private final HashMap<MenuOption,Integer> orders;


    public Orders(HashMap<MenuOption, Integer> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(HashMap<MenuOption, Integer> orders) {
        throwIfMaximumOrderCountExceeded(orders);
    }

    private void throwIfMaximumOrderCountExceeded(HashMap<MenuOption, Integer> menusAndCount) {
        int totalCount = 0;
        for (Integer count : menusAndCount.values()) {
            totalCount+=count;
        }
        if(totalCount>20){
            throw new IllegalArgumentException(MAXIMUM_ORDER_COUNT_EXCEEDED.getMessage());
        }
    }

}
