package christmas.domain.discount;

import static christmas.util.Calender.DECEMBER;

import christmas.domain.Orders;

public class WeekAndWeekendDiscount {

    private final static int DISCOUNT_UNIT = 2023;

    public int discount(Orders orders, int date) {
        if (DECEMBER.isWeekend(date)) {
            return DISCOUNT_UNIT * orders.getMainMenusCount();
        }
        return DISCOUNT_UNIT * orders.getDessertMenusCount();
    }

}
