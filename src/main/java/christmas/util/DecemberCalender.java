package christmas.util;

import java.util.List;

public enum DecemberCalender {

    DECEMBER(31, List.of(3, 10, 17, 24, 25, 31));

    private static final int CHRISTMAS = 25;
    private static final int FIRST_WEEKEND_FRIDAY = 1;
    private static final int FIRST_WEEKEND_SATURDAY = 2;
    private final int endDate;
    private final List<Integer> star;

    DecemberCalender(int endDate, List<Integer> star) {
        this.endDate = endDate;
        this.star = star;
    }

    public static boolean isDdayEventTerm(int date) {
        return date <= CHRISTMAS;
    }

    public static boolean isWeekend(int date) {
        return isFriday(date) || isSaturday(date);
    }

    private static boolean isFriday(int date) {
        return (date - FIRST_WEEKEND_FRIDAY) % 7 == 0;
    }

    private static boolean isSaturday(int date) {
        return (date - FIRST_WEEKEND_SATURDAY) % 7 == 0;
    }

    public static boolean isStarDate(int date) {
        return DECEMBER.star.contains(date);
    }

    public static boolean isEventTerm(int date) {
        return false;
    }

    public static boolean isExistingDate(int date) {
        return false;
    }
}
