package christmas.util;

import java.util.List;

public enum Calender {

    DECEMBER(31, List.of(3, 10, 17, 24, 25, 31), 31);

    public static final int CHRISTMAS = 25;
    private static final int FIRST_WEEKEND_FRIDAY = 1;
    private static final int FIRST_WEEKEND_SATURDAY = 2;
    private final int endDate;
    private final List<Integer> star;
    private final int eventEndDate;

    Calender(int endDate, List<Integer> star, int eventEndDate) {
        this.endDate = endDate;
        this.star = star;
        this.eventEndDate = eventEndDate;
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
        return date <= DECEMBER.eventEndDate;
    }

    public static boolean isExistingDate(int date) {
        return date <= DECEMBER.endDate;
    }
}
