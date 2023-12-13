package christmas.domain.discount;

import christmas.util.DecemberCalender;

public class SpecialDiscount {

    private static final int DISCOUNT_UNIT = 1000;

    private static final int NO_DISCOUNT = 0;

    public int discount(int date) {
        if (DecemberCalender.isStarDate(date)) {
            return DISCOUNT_UNIT;
        }
        return NO_DISCOUNT;
    }

}
