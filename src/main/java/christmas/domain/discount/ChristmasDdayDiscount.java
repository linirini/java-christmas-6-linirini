package christmas.domain.discount;

import static christmas.util.Calender.CHRISTMAS;

import christmas.util.Calender;

public class ChristmasDdayDiscount {

    private static final int INITIAL_DISCOUNT = 1000;
    private static final int DISCOUNT_UNIT = 100;

    public int discount(int date) {
        if (Calender.isDdayEventTerm(date)) {
            return INITIAL_DISCOUNT + (CHRISTMAS - date) * DISCOUNT_UNIT;
        }
        return 0;
    }

}
