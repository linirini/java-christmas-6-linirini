package christmas.domain;

public class Benefit {

    private final int christmasDdayDiscountBenefit;
    private final int weekDiscountBenefit;
    private final int weekendDiscountBenefit;
    private final int specialDiscountBenefit;
    private final int giftEventBenefit;

    public Benefit(int christmasDdayDiscountBenefit, int weekDiscountBenefit,
            int weekedDiscountBenefit, int specialDiscountBenefit, int giftEventBenefit) {
        this.christmasDdayDiscountBenefit = christmasDdayDiscountBenefit;
        this.weekDiscountBenefit = weekDiscountBenefit;
        this.weekendDiscountBenefit = weekedDiscountBenefit;
        this.specialDiscountBenefit = specialDiscountBenefit;
        this.giftEventBenefit = giftEventBenefit;
    }

    public int getTotalBenefitsPrice() {
        return christmasDdayDiscountBenefit + weekDiscountBenefit + weekendDiscountBenefit
                + specialDiscountBenefit + giftEventBenefit;
    }


}
