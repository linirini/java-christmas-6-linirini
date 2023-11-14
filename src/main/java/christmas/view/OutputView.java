package christmas.view;

import static christmas.view.viewenum.OutputEnum.ORDER_AMOUNT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.ORDER_MENU_OUTPUT;

import java.util.HashMap;
import java.util.Map.Entry;

public class OutputView {

    private static final String COUNT_UNIT = "개";
    private static final String MONEY_UNIT = "원";

    public void printOrderedMenus(HashMap<String, Integer> menus) {
        System.out.println(ORDER_MENU_OUTPUT.getMessage());
        for (Entry<String, Integer> entry : menus.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + COUNT_UNIT);
        }
    }

    public void printOrdersAmount(int amount) {
        System.out.println(ORDER_AMOUNT_OUTPUT.getMessage());
        System.out.println(String.format("%,d", amount) + MONEY_UNIT);
    }

}
