package christmas.domain.discount;

import static christmas.util.Calender.DECEMBER;

import christmas.domain.Orders;

public class WeekAndWeekendDiscount {

    private final static int DISCOUNT_UNIT = 2023;
    private static final int NO_DISCOUNT = 0;

    public int weekDiscount(Orders orders, int date) {
        if (!DECEMBER.isWeekend(date)) {
            return DISCOUNT_UNIT * orders.getDessertMenusCount();
        }
        return NO_DISCOUNT;
    }

    public int weekendDiscount(Orders orders, int date) {
        if (DECEMBER.isWeekend(date)) {
            return DISCOUNT_UNIT * orders.getMainMenusCount();
        }
        return NO_DISCOUNT;
    }

}
