package christmas.view;

import static christmas.domain.Gift.NONE;
import static christmas.view.OutputEnum.BENEFITS_NOTICE_PREFIX;
import static christmas.view.OutputEnum.BENEFITS_NOTICE_SUFFIX;
import static christmas.view.OutputEnum.COUNT_UNIT;
import static christmas.view.OutputEnum.GIFT_TITLE;
import static christmas.view.OutputEnum.MONEY_UNIT;
import static christmas.view.OutputEnum.ORDERS_TITLE;
import static christmas.view.OutputEnum.TOTAL_ORDERS_PRICE_TITLE;

import christmas.domain.Badge;
import christmas.domain.Gift;
import christmas.domain.Orders;
import christmas.domain.menu.MenuOption;
import java.text.DecimalFormat;
import java.util.Map.Entry;

public class OutputView {

    public void printBenefitsNotice(int date) {
        System.out.println(BENEFITS_NOTICE_PREFIX.getMessage() + date + BENEFITS_NOTICE_SUFFIX);
    }

    public void printOrders(Orders orders) {
        System.out.println(ORDERS_TITLE);
        for (Entry<MenuOption, Integer> entry : orders.getOrders().entrySet()) {
            System.out.println(entry.getKey().getName() + ' ' + entry.getValue() + COUNT_UNIT);
        }
    }

    public void printTotalOrdersPrice(int amount) {
        System.out.println(TOTAL_ORDERS_PRICE_TITLE.getMessage());
        System.out.println(formatMoney(amount) + MONEY_UNIT);
    }

    public void printGiftMenu(Gift gift) {
        System.out.println(GIFT_TITLE.getMessage());
        if (gift == Gift.NONE) {
            System.out.println(NONE);
            return;
        }
        System.out.println(gift.menu.getName() + ' ' + gift.count + COUNT_UNIT);
    }

    public void printBenefits() {

    }

    public void printTotalBenefitsPrice(int amount) {

    }

    public void printActualPaymentPrice(int amount) {

    }

    public void printEventBadge(Badge badge) {

    }

    private String formatMoney(int amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(amount);
    }

}
