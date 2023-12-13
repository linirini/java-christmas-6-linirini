package christmas.domain.discount;

import static christmas.util.DecemberCalender.CHRISTMAS;

import christmas.util.DecemberCalender;

public class ChristmasDdayDiscount {

    private static final int INITIAL_DISCOUNT = 1000;
    private static final int DISCOUNT_UNIT = 100;
    private static final int NO_DISCOUNT = 0;

    public int discount(int date) {
        if (DecemberCalender.isDdayEventTerm(date)) {
            return INITIAL_DISCOUNT + (CHRISTMAS - date) * DISCOUNT_UNIT;
        }
        return NO_DISCOUNT;
    }

}
