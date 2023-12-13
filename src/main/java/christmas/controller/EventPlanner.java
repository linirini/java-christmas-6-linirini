package christmas.controller;

import static christmas.util.Calender.DECEMBER;

import christmas.domain.Badge;
import christmas.domain.Benefit;
import christmas.domain.Gift;
import christmas.domain.Orders;
import christmas.domain.discount.ChristmasDdayDiscount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekAndWeekendDiscount;

public class EventPlanner {

    private static final int MINIMUM_ORDERS_PRICE = 10000;
    private final ChristmasDdayDiscount christmasDdayDiscount = new ChristmasDdayDiscount();
    private final WeekAndWeekendDiscount weekAndWeekendDiscount = new WeekAndWeekendDiscount();
    private final SpecialDiscount specialDiscount = new SpecialDiscount();

    public Benefit applyEvents(int date, Orders orders){
        if(isEventApplicable(orders)){
            int christmasDdayDiscountBenefit = christmasDdayDiscount.discount(date);
            int weekDiscountBenefit = weekAndWeekendDiscount.weekDiscount(orders, date);
            int weekendDiscountBenefit = weekAndWeekendDiscount.weekendDiscount(orders, date);
            int specialDiscountBenefit = specialDiscount.discount(date);
            Gift giftBenefit = Gift.receiveGift(orders.getTotalPrice());
            return new Benefit(christmasDdayDiscountBenefit, weekDiscountBenefit,
                    weekendDiscountBenefit, specialDiscountBenefit,giftBenefit);
        }
        return new Benefit();
    }
    public Badge getBadge(int amount){
        return Badge.getBadge(amount);
    }

    private boolean isEventApplicable(Orders orders) {
        return orders.getTotalPrice()>MINIMUM_ORDERS_PRICE;
    }

    public boolean isValidDate(int date){
        return DECEMBER.isExistingDate(date) && DECEMBER.isEventTerm(date);
    }

    public int getActualPaymentPrice(int totalOrdersPrice,Benefit benefit){
        return totalOrdersPrice - benefit.getTotalDiscountPrice();
    }
}
