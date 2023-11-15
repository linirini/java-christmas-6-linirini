package christmas.domain.event;

public class EventBenefit {

    private final int christmasDdayBenefit;
    private final int weekBenefit;
    private final int weekendBenefit;
    private final int specialBenefit;
    private final int giftBenefit;

    public EventBenefit(int christmasDdayBenefit, int weekBenefit, int weekendBenefit,
            int specialBenefit, int giftBenefit) {
        this.christmasDdayBenefit = christmasDdayBenefit;
        this.weekBenefit = weekBenefit;
        this.weekendBenefit = weekendBenefit;
        this.specialBenefit = specialBenefit;
        this.giftBenefit = giftBenefit;
    }

    public int getTotalEventBenefit() {
        return christmasDdayBenefit + weekBenefit + weekendBenefit + specialBenefit + giftBenefit;
    }

}