package christmas.domain.event.discount;

import static christmas.util.DecemberCalender.isAfterChristmas;

public class ChristmasDdayDiscount {

    private final static int INIT = 1000;
    private final static int DISCOUNT = 100;
    private final static int START_DATE = 1;

    public int discount(int date) {
        if (isAfterChristmas(date)) {
            return 0;
        }
        return INIT + DISCOUNT * (date - START_DATE);
    }

}
