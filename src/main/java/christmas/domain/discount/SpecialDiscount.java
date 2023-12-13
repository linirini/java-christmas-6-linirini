package christmas.domain.discount;

import static christmas.util.Calender.DECEMBER;

public class SpecialDiscount {

    private static final int DISCOUNT_UNIT = 1000;

    private static final int NO_DISCOUNT = 0;

    public int discount(int date) {
        if (DECEMBER.isStarDate(date)) {
            return DISCOUNT_UNIT;
        }
        return NO_DISCOUNT;
    }

}
