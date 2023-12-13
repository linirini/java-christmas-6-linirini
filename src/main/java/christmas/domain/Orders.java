package christmas.domain;

import christmas.domain.menu.MenuOption;
import java.util.HashMap;

public class Orders {

    private final HashMap<MenuOption, Integer> orders;

    public Orders(HashMap<MenuOption, Integer> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(HashMap<MenuOption, Integer> orders) {
    }

    public int getTotalPrice(){
        return -1;
    }

    public int getOrdersCount(){
        return -1;
    }

    public int getMainMenusCount() {
        return -1;
    }

    public int getDessertMenusCount() {
        return -1;
    }

}
