package christmas.view;

import static christmas.view.OutputEnum.BENEFITS_NOTICE_PREFIX;
import static christmas.view.OutputEnum.BENEFITS_NOTICE_SUFFIX;
import static christmas.view.OutputEnum.COUNT_UNIT;
import static christmas.view.OutputEnum.ORDERS_TITLE;

import christmas.domain.Badge;
import christmas.domain.Gift;
import christmas.domain.Orders;
import christmas.domain.menu.MenuOption;
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

    }

    public void printGiftMenu(Gift gift) {

    }

    public void printBenefits() {

    }

    public void printTotalBenefitsPrice(int amount) {

    }

    public void printActualPaymentPrice(int amount) {

    }

    public void printEventBadge(Badge badge) {

    }

}
