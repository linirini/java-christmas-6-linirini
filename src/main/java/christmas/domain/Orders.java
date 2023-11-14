package christmas.domain;

import christmas.domain.menu.MenuOption;
import java.util.HashMap;

public class Orders {

    private final HashMap<MenuOption,Integer> orders;


    public Orders(HashMap<String, Integer> orders) {
        this.orders = convertToOrders(orders);
    }

    private HashMap<MenuOption, Integer> convertToOrders(HashMap<String, Integer> orders) {
        return null;
    }

}
