package christmas.domain;

public class Benefit {

    private final int christmasDdayDiscountBenefit;
    private final int weekDiscountBenefit;
    private final int weekendDiscountBenefit;
    private final int specialDiscountBenefit;
    private final Gift giftEventBenefit;

    public Benefit(){
        this.christmasDdayDiscountBenefit = 0;
        this.weekDiscountBenefit = 0;
        this.weekendDiscountBenefit = 0;
        this.specialDiscountBenefit = 0;
        this.giftEventBenefit = Gift.NONE;
    }

    public Benefit(int christmasDdayDiscountBenefit, int weekDiscountBenefit,
            int weekendDiscountBenefit, int specialDiscountBenefit, Gift giftEventBenefit) {
        this.christmasDdayDiscountBenefit = christmasDdayDiscountBenefit;
        this.weekDiscountBenefit = weekDiscountBenefit;
        this.weekendDiscountBenefit = weekendDiscountBenefit;
        this.specialDiscountBenefit = specialDiscountBenefit;
        this.giftEventBenefit = giftEventBenefit;
    }

    public int getChristmasDdayDiscountBenefit() {
        return christmasDdayDiscountBenefit;
    }

    public int getWeekDiscountBenefit() {
        return weekDiscountBenefit;
    }

    public int getWeekendDiscountBenefit() {
        return weekendDiscountBenefit;
    }

    public int getSpecialDiscountBenefit() {
        return specialDiscountBenefit;
    }

    public Gift getGiftEventBenefit(){
        return giftEventBenefit;
    }

    public int getTotalBenefitsPrice() {
        return getTotalDiscountPrice() + getGiftEventBenefitPrice();
    }

    public int getGiftEventBenefitPrice() {
        return giftEventBenefit.getMenu().getPrice()*giftEventBenefit.count;
    }

    public int getTotalDiscountPrice() {
        return christmasDdayDiscountBenefit + weekDiscountBenefit + weekendDiscountBenefit
                + specialDiscountBenefit;
    }

    public boolean noBenefitExists() {
        return christmasDdayDiscountBenefit == 0 && weekDiscountBenefit == 0
                && weekendDiscountBenefit == 0 && specialDiscountBenefit == 0
                && giftEventBenefit == Gift.NONE;
    }

}
