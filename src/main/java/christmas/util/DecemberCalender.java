package christmas.util;

import java.time.DayOfWeek;
import java.util.Arrays;

public enum DecemberCalender {

    DECEMBER(31, DayOfWeek.FRIDAY, new int[]{3, 10, 17, 24, 25, 31});

    private static final int CHRISTMAS = 25;
    private final int days;
    private final DayOfWeek startingDayOfWeek;
    private final int[] starDates;

    DecemberCalender(int days, DayOfWeek dayOfWeek, int[] starDates) {
        this.days = days;
        this.startingDayOfWeek = dayOfWeek;
        this.starDates = starDates;
    }

    public static boolean isValidDate(int date) {
        return date > 0 && date <= DECEMBER.days;
    }

    public static boolean isAfterChristmas(int date) {return date > CHRISTMAS;}

    public static boolean isWeekend(int date) {
        DayOfWeek day = DECEMBER.startingDayOfWeek.plus(date - 1);
        return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY;
    }

    public static boolean hasStar(int date) {
        return Arrays.stream(DECEMBER.starDates).anyMatch(starDates -> starDates == date);
    }

}
