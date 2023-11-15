package christmas.view;

import static christmas.view.viewenum.OutputEnum.BENEFIT_DETAIL_OUTPUT;
import static christmas.view.viewenum.OutputEnum.BENEFIT_INTRODUCTION_OUTPUT;
import static christmas.view.viewenum.OutputEnum.CHRISTMAS_D_DAY_DISCOUNT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.COUNT_UNIT;
import static christmas.view.viewenum.OutputEnum.DECEMBER_OUTPUT;
import static christmas.view.viewenum.OutputEnum.EVENT_BADGE;
import static christmas.view.viewenum.OutputEnum.EVENT_PLANNER_INTRODUCTION_OUTPUT;
import static christmas.view.viewenum.OutputEnum.EXPECTED_PAY_AMOUNT;
import static christmas.view.viewenum.OutputEnum.GIFT_BENEFIT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.GIFT_MENU_OUTPUT;
import static christmas.view.viewenum.OutputEnum.MONEY_UNIT;
import static christmas.view.viewenum.OutputEnum.NONE;
import static christmas.view.viewenum.OutputEnum.ORDER_AMOUNT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.ORDER_MENU_OUTPUT;
import static christmas.view.viewenum.OutputEnum.SPECIAL_DISCOUNT;
import static christmas.view.viewenum.OutputEnum.TOTAL_BENEFIT_AMOUNT;
import static christmas.view.viewenum.OutputEnum.WEEKEND_DISCOUNT_OUTPUT;
import static christmas.view.viewenum.OutputEnum.WEEK_DISCOUNT_OUTPUT;

import christmas.domain.event.EventBenefit;
import christmas.domain.event.Gift;
import java.util.HashMap;
import java.util.Map.Entry;

public class OutputView {

    public void printEventPlannerIntroduction() {
        System.out.println(EVENT_PLANNER_INTRODUCTION_OUTPUT.getMessage());
    }

    public void printBenefitIntroductionAtDate(int date) {
        System.out.println(DECEMBER_OUTPUT.getMessage() + " " + date
                + BENEFIT_INTRODUCTION_OUTPUT.getMessage());
    }

    public void printOrderedMenus(HashMap<String, Integer> menus) {
        System.out.println(ORDER_MENU_OUTPUT.getMessage());
        for (Entry<String, Integer> entry : menus.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + COUNT_UNIT.getMessage());
        }
    }

    public void printOrdersAmount(int amount) {
        System.out.println(ORDER_AMOUNT_OUTPUT.getMessage());
        printAmount(amount);
    }

    public void printGiftMenu(Gift gift) {
        System.out.println(GIFT_MENU_OUTPUT.getMessage());
        if (gift == Gift.NO_GIFT) {
            System.out.println(gift.getGiftName());
            return;
        }
        System.out.println(gift.getGiftName() + " " + gift.getCount() + COUNT_UNIT.getMessage());
    }

    public void printNoneBenefit() {
        System.out.println(BENEFIT_DETAIL_OUTPUT.getMessage());
        System.out.println(NONE.getMessage());
    }

    public void printBenefitDetails(EventBenefit eventBenefit) {
        System.out.println(BENEFIT_DETAIL_OUTPUT.getMessage());
        printChristmasDdayDiscountBenefit(eventBenefit.getChristmasDdayBenefit());
        printWeekDiscountBenefit(eventBenefit.getWeekBenefit());
        printWeekendDiscountBenefit(eventBenefit.getWeekendBenefit());
        printSpecialDiscountBenefit(eventBenefit.getSpecialBenefit());
        printGiftBenefit(eventBenefit.getGiftBenefit());
    }

    private void printChristmasDdayDiscountBenefit(int amount) {
        if (amount != 0) {
            System.out.print(CHRISTMAS_D_DAY_DISCOUNT_OUTPUT.getMessage());
            printBenefitAmount(amount);
        }
    }

    private void printWeekDiscountBenefit(int amount) {
        if (amount != 0) {
            System.out.print(WEEK_DISCOUNT_OUTPUT.getMessage());
            printBenefitAmount(amount);
        }
    }

    private void printWeekendDiscountBenefit(int amount) {
        if (amount != 0) {
            System.out.print(WEEKEND_DISCOUNT_OUTPUT.getMessage());
            printBenefitAmount(amount);
        }
    }

    private void printSpecialDiscountBenefit(int amount) {
        if (amount != 0) {
            System.out.print(SPECIAL_DISCOUNT.getMessage());
            printBenefitAmount(amount);
        }
    }

    private void printGiftBenefit(int amount) {
        if (amount != 0) {
            System.out.print(GIFT_BENEFIT_OUTPUT.getMessage());
            printBenefitAmount(amount);
        }
    }

    public void printTotalBenefitAmount(int amount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage());
        if (amount == 0) {
            printAmount(amount);
            return;
        }
        printBenefitAmount(amount);
    }

    private void printBenefitAmount(int amount) {
        System.out.println(String.format("-%,d", amount) + MONEY_UNIT.getMessage());
    }

    public void printExpectedPayAmount(int amount) {
        System.out.println(EXPECTED_PAY_AMOUNT.getMessage());
        printAmount(amount);
    }

    private void printAmount(int amount) {
        System.out.println(String.format("%,d", amount) + MONEY_UNIT.getMessage());
    }

    public void printEventBadge(String viewName) {
        System.out.println(EVENT_BADGE.getMessage());
        System.out.println(viewName);
    }

    public void printLineBreak() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}
