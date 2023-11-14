package christmas.view;

import static christmas.view.viewenum.OutputEnum.ORDER_MENU_OUTPUT;

import java.util.HashMap;
import java.util.Map.Entry;

public class OutputView {

    private static final String UNIT = "개";

    public void printOrderedMenus(HashMap<String, Integer> menus) {
        System.out.println(ORDER_MENU_OUTPUT.getMessage());
        for (Entry<String, Integer> entry : menus.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + UNIT);
        }
    }

}
