package christmas.domain.event.discount;

import static christmas.util.DecemberCalender.isWeekend;

import christmas.domain.Orders;

public class DayOfTheWeekDiscount {

    private static int DISCOUNT = 2023;

    public int weekDiscount(int date, Orders orders){
        if(!isWeekend(date)) {
            return DISCOUNT * orders.getDessertCount();
        }
        return 0;
    }

    public int weekendDiscount(int date, Orders orders){
        if(isWeekend(date)){
            return DISCOUNT*orders.getMainDishCount();
        }
        return 0;
    }

}
