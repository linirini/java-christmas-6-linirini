package christmas.view;

import static christmas.view.viewenum.OutputEnum.COUNT_UNIT;
import static christmas.view.viewenum.OutputEnum.GIFT;
import static christmas.view.viewenum.OutputEnum.GIFT_MENU_OUTPUT;
import static christmas.view.viewenum.OutputEnum.MONEY_UNIT;
import static christmas.view.viewenum.OutputEnum.NONE;
import static christmas.view.viewenum.OutputEnum.ORDER_AMOUNT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.ORDER_MENU_OUTPUT;

import java.util.HashMap;
import java.util.Map.Entry;

public class OutputView {

    public void printOrderedMenus(HashMap<String, Integer> menus) {
        System.out.println(ORDER_MENU_OUTPUT.getMessage());
        for (Entry<String, Integer> entry : menus.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + COUNT_UNIT.getMessage());
        }
    }

    public void printOrdersAmount(int amount) {
        System.out.println(ORDER_AMOUNT_OUTPUT.getMessage());
        System.out.println(String.format("%,d", amount) + MONEY_UNIT.getMessage());
    }

    public void printGiftMenu(boolean receiveGift) {
        System.out.println(GIFT_MENU_OUTPUT.getMessage());
        if (receiveGift) {
            System.out.println(GIFT.getMessage());
            return;
        }
        System.out.println(NONE.getMessage());
    }

}
