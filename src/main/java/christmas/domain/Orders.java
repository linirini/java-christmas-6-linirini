package christmas.domain;

import christmas.domain.menu.MenuOption;
import java.util.HashMap;

public class Orders {

    private final HashMap<MenuOption,Integer> orders;


    public Orders(HashMap<MenuOption, Integer> orders) {this.orders = orders;}

}
