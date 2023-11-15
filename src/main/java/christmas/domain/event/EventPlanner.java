package christmas.domain.event;

import christmas.domain.Orders;
import christmas.domain.event.discount.ChristmasDdayDiscount;
import christmas.domain.event.discount.DayOfTheWeekDiscount;
import christmas.domain.event.discount.SpecialDiscount;

public class EventPlanner {

    private static final int MINIMUM_AMOUNT = 10000;

    private final ChristmasDdayDiscount christmasDdayDiscount = new ChristmasDdayDiscount();
    private final DayOfTheWeekDiscount dayOfTheWeekDiscount = new DayOfTheWeekDiscount();
    private final SpecialDiscount specialDiscount = new SpecialDiscount();

    public boolean isMinimumAmountForEventMet(int amount) {
        return amount >= MINIMUM_AMOUNT;
    }

    public Gift presentGift(int totalAmountBeforeDiscount) {
        return Gift.receiveGift(totalAmountBeforeDiscount);
    }

    public EventBenefit calculateEventBenefit(int date, Orders orders, Gift gift) {
        return new EventBenefit(christmasDdayDiscount.discount(date),
                dayOfTheWeekDiscount.weekDiscount(date, orders),
                dayOfTheWeekDiscount.weekendDiscount(date, orders), specialDiscount.discount(date),
                gift.getGiftBenefit());
    }

    public int calculateExpectedPayAmount(int totalAmountBeforeDiscount, int discountAmount) {
        return totalAmountBeforeDiscount - discountAmount;
    }

}
