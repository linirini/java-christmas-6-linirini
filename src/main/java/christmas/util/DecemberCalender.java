package christmas.util;

import java.time.DayOfWeek;

public enum DecemberCalender {

    DECEMBER(31,DayOfWeek.FRIDAY, new int[]{3,10,17,24,25,31});

    private final int days;
    private final DayOfWeek startingDayOfWeek;
    private final int[] starDates;

    DecemberCalender(int days,DayOfWeek dayOfWeek, int[] starDates){
        this.days=days;
        this.startingDayOfWeek = dayOfWeek;
        this.starDates = starDates;
    }

    public static boolean isValidDate(int date) {
        return date>0&&date<=DECEMBER.days;
    }

}
