package christmas.domain.event.discount;

import christmas.domain.Orders;

public class DayOfTheWeekDiscount {

    private static int DISCOUNT = 2023;

    public int weekDiscount(Orders orders,int date){
        return DISCOUNT*orders.getDessertCount();
    }

    public int weekendDiscount(Orders orders,int date){
        return DISCOUNT*orders.getMainDishCount();
    }

}
