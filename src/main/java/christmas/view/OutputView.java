package christmas.view;

import static christmas.view.viewenum.OutputEnum.CHRISTMAS_D_DAY_DISCOUNT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.COUNT_UNIT;
import static christmas.view.viewenum.OutputEnum.GIFT_BENEFIT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.GIFT_MENU_OUTPUT;
import static christmas.view.viewenum.OutputEnum.MONEY_UNIT;
import static christmas.view.viewenum.OutputEnum.NONE;
import static christmas.view.viewenum.OutputEnum.ORDER_AMOUNT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.ORDER_MENU_OUTPUT;
import static christmas.view.viewenum.OutputEnum.WEEKEND_DISCOUNT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.WEEK_DISCOUNT_OUTPUT;

import java.util.HashMap;
import java.util.Map.Entry;

public class OutputView {

    public void printOrderedMenus(HashMap<String, Integer> menus) {
        System.out.println(ORDER_MENU_OUTPUT.getMessage());
        printMenus(menus);
    }

    public void printOrdersAmount(int amount) {
        System.out.println(ORDER_AMOUNT_OUTPUT.getMessage());
        System.out.println(String.format("%,d", amount) + MONEY_UNIT.getMessage());
    }

    public void printGiftMenu(HashMap<String, Integer> gift) {
        System.out.println(GIFT_MENU_OUTPUT.getMessage());
        if (gift.isEmpty()) {
            System.out.println(NONE.getMessage());
            return;
        }
        printMenus(gift);
    }

    private void printMenus(HashMap<String, Integer> menus) {
        for (Entry<String, Integer> entry : menus.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + COUNT_UNIT.getMessage());
        }
    }

    private void printChristmasDdayDiscountBenefit(int amount) {
        if(amount!=0) {
            System.out.println(
                    CHRISTMAS_D_DAY_DISCOUNT_OUTPUT.getMessage() + String.format("-%,d", amount)
                            + MONEY_UNIT.getMessage());
        }
    }

    private void printWeekDiscountBenefit(int amount) {
        if(amount!=0) {
            System.out.println(WEEK_DISCOUNT_OUTPUT.getMessage() + String.format("-%,d", amount)
                    + MONEY_UNIT.getMessage());
        }
    }

    private void printWeekendDiscountBenefit(int amount) {
        if(amount!=0) {
            System.out.println(WEEKEND_DISCOUNT_OUTPUT.getMessage() + String.format("-%,d", amount)
                    + MONEY_UNIT.getMessage());
        }
    }

    private void printGiftBenefit(int amount) {
        if(amount!=0) {
            System.out.println(GIFT_BENEFIT_OUTPUT.getMessage() + String.format("-%,d", amount)
                    + MONEY_UNIT.getMessage());
        }
    }

}
