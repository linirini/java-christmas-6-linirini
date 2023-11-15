package christmas.domain.event.discount;

import static christmas.util.DecemberCalender.hasStar;

public class SpecialDiscount {

    private final static int DISCOUNT = 1000;

    public int discount(int date) {
        if (hasStar(date)) {
            return DISCOUNT;
        }
        return 0;
    }

}
