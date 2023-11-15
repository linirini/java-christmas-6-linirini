package christmas.domain;

import christmas.domain.event.EventBenefit;
import christmas.domain.event.Gift;
import christmas.domain.event.discount.ChristmasDdayDiscount;
import christmas.domain.event.discount.DayOfTheWeekDiscount;
import christmas.domain.event.discount.SpecialDiscount;

public class EventPlanner {

    private static final int MINIMUM_AMOUNT = 10000;

    private ChristmasDdayDiscount christmasDdayDiscount = new ChristmasDdayDiscount();
    private DayOfTheWeekDiscount dayOfTheWeekDiscount = new DayOfTheWeekDiscount();
    private SpecialDiscount specialDiscount = new SpecialDiscount();

    public boolean isMinimumAmountForEventMet(int amount) {
        return amount >= MINIMUM_AMOUNT;
    }

    public Gift presentGift(int totalAmountBeforeDiscount) {
        return Gift.receiveGift(totalAmountBeforeDiscount);
    }

    public EventBenefit getEventBenefit(int date, Orders orders, int totalAmountBeforeDiscount,
            Gift gift) {
        return new EventBenefit(christmasDdayDiscount.discount(date),
                dayOfTheWeekDiscount.weekDiscount(date, orders),
                dayOfTheWeekDiscount.weekendDiscount(date, orders), specialDiscount.discount(date),
                gift.getGiftBenefit());
    }

}
