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

    public static EventBenefit getDefaultEventBenefit() {
        return new EventBenefit(0,0,0,0,0);
    }

    public int getTotalEventBenefit() {
        return christmasDdayBenefit + weekBenefit + weekendBenefit + specialBenefit + giftBenefit;
    }

    public int getChristmasDdayBenefit() {
        return christmasDdayBenefit;
    }

    public int getWeekBenefit() {
        return weekBenefit;
    }

    public int getWeekendBenefit() {
        return weekendBenefit;
    }

    public int getSpecialBenefit() {
        return specialBenefit;
    }

    public int getGiftBenefit() {
        return giftBenefit;
    }

}