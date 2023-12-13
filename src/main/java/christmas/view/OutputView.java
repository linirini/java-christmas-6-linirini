package christmas.view;

import static christmas.view.OutputEnum.ACTUAL_PAYMENT_PRICE_TITLE;
import static christmas.view.OutputEnum.BADGE_TITLE;
import static christmas.view.OutputEnum.BENEFITS_NOTICE_PREFIX;
import static christmas.view.OutputEnum.BENEFITS_NOTICE_SUFFIX;
import static christmas.view.OutputEnum.BENEFITS_TITLE;
import static christmas.view.OutputEnum.CHRISTMAS_D_DAY_DISCOUNT;
import static christmas.view.OutputEnum.COUNT_UNIT;
import static christmas.view.OutputEnum.EVENT_INTRODUCTION;
import static christmas.view.OutputEnum.GIFT_EVENT;
import static christmas.view.OutputEnum.GIFT_TITLE;
import static christmas.view.OutputEnum.MONEY_UNIT;
import static christmas.view.OutputEnum.NONE;
import static christmas.view.OutputEnum.ORDERS_TITLE;
import static christmas.view.OutputEnum.SPECIAL_DISCOUNT;
import static christmas.view.OutputEnum.TOTAL_BENEFITS_PRICE_TITLE;
import static christmas.view.OutputEnum.TOTAL_ORDERS_PRICE_TITLE;
import static christmas.view.OutputEnum.WEEKEND_DISCOUNT;
import static christmas.view.OutputEnum.WEEK_DISCOUNT;

import christmas.domain.Badge;
import christmas.domain.Benefit;
import christmas.domain.Gift;
import christmas.domain.Orders;
import christmas.domain.menu.MenuOption;
import java.text.DecimalFormat;
import java.util.Map.Entry;

public class OutputView {

    public void printEventIntroduction(){
        System.out.println(EVENT_INTRODUCTION.getMessage());
    }

    public void printBenefitsNotice(int date) {
        System.out.println(BENEFITS_NOTICE_PREFIX.getMessage() + date + BENEFITS_NOTICE_SUFFIX.getMessage());
    }

    public void printOrders(Orders orders) {
        System.out.println(ORDERS_TITLE.getMessage());
        for (Entry<MenuOption, Integer> entry : orders.getOrders().entrySet()) {
            System.out.println(entry.getKey().getName() + ' ' + entry.getValue() + COUNT_UNIT.getMessage());
        }
    }

    public void printTotalOrdersPrice(int amount) {
        System.out.println(TOTAL_ORDERS_PRICE_TITLE.getMessage());
        System.out.println(formatPrice(amount) + MONEY_UNIT.getMessage());
    }

    public void printGiftMenu(Gift gift) {
        System.out.println(GIFT_TITLE.getMessage());
        if (gift == Gift.NONE) {
            System.out.println(NONE.getMessage());
            return;
        }
        System.out.println(gift.menu.getName() + ' ' + gift.count + COUNT_UNIT.getMessage());
    }

    public void printBenefits(Benefit benefit) {
        System.out.println(BENEFITS_TITLE.getMessage());
        if(benefit.noBenefitExists()){
            System.out.println(NONE.getMessage());
            return;
        }
        printChristmasDdayDiscountBenefit(benefit.getChristmasDdayDiscountBenefit());
        printWeekDiscountBenefit(benefit.getWeekDiscountBenefit());
        printWeekendDiscountBenefit(benefit.getWeekendDiscountBenefit());
        printSpecialDiscountBenefit(benefit.getSpecialDiscountBenefit());
        printGiftEventBenefit(benefit.getGiftEventBenefitPrice());
    }

    private void printChristmasDdayDiscountBenefit(int amount) {
        printIfBenefitExists(amount, CHRISTMAS_D_DAY_DISCOUNT);
    }

    private void printWeekDiscountBenefit(int amount) {
        printIfBenefitExists(amount, WEEK_DISCOUNT);
    }

    private void printWeekendDiscountBenefit(int amount) {
        printIfBenefitExists(amount, WEEKEND_DISCOUNT);
    }

    private void printSpecialDiscountBenefit(int amount) {
        printIfBenefitExists(amount, SPECIAL_DISCOUNT);
    }

    private void printGiftEventBenefit(int amount) {
        printIfBenefitExists(amount, GIFT_EVENT);
    }

    private void printIfBenefitExists(int amount, OutputEnum benefitOption) {
        if (amount != 0) {
            System.out.println(benefitOption.getMessage() + formatBenefit(amount) + MONEY_UNIT.getMessage());
        }
    }

    public void printTotalBenefitsPrice(int amount) {
        System.out.println(TOTAL_BENEFITS_PRICE_TITLE.getMessage());
        if(amount!=0){
            System.out.println(formatBenefit(amount)+MONEY_UNIT.getMessage());
            return;
        }
        System.out.println(formatPrice(amount)+MONEY_UNIT.getMessage());
    }

    public void printActualPaymentPrice(int amount) {
        System.out.println(ACTUAL_PAYMENT_PRICE_TITLE.getMessage());
        System.out.println(formatPrice(amount)+MONEY_UNIT.getMessage());
    }

    private String formatPrice(int amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(amount);
    }

    private String formatBenefit(int amount) {
        DecimalFormat df = new DecimalFormat("-###,###");
        return df.format(amount);
    }

    public void printEventBadge(Badge badge) {
        System.out.println(BADGE_TITLE.getMessage());
        if(badge== Badge.NONE){
            System.out.println(NONE.getMessage());
            return;
        }
        System.out.println(badge.getName());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}
