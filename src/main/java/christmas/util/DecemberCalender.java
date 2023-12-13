package christmas.util;

import java.util.List;

public enum DecemberCalender {

    DECEMBER(31, 1, 2, List.of(3, 10, 17, 24, 25, 31), 31);

    public static final int CHRISTMAS = 25;
    private final int endDate;
    private final List<Integer> star;
    private final int eventEndDate;
    private final int firstFriday;
    private final int firstSaturday;

    DecemberCalender(int endDate, int firstFriday, int firstSaturday, List<Integer> star, int eventEndDate) {
        this.endDate = endDate;
        this.firstFriday =firstFriday;
        this.firstSaturday = firstSaturday;
        this.star = star;
        this.eventEndDate = eventEndDate;
    }

    public boolean isDdayEventTerm(int date) {
        return date <= CHRISTMAS;
    }

    public boolean isWeekend(int date) {
        return isFriday(date) || isSaturday(date);
    }

    private boolean isFriday(int date) {
        return (date - this.firstFriday) % 7 == 0;
    }

    private boolean isSaturday(int date) {
        return (date - this.firstSaturday) % 7 == 0;
    }

    public boolean isStarDate(int date) {
        return this.star.contains(date);
    }

    public boolean isEventTerm(int date) {
        return date <= this.eventEndDate;
    }

    public boolean isExistingDate(int date) {
        return date <= this.endDate;
    }
}
