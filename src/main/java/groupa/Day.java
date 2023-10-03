package groupa;

import static java.util.Calendar.*;

public enum Day {
    INSTANCE;
    private static int dayIndex = 0;

    private static final int[] daysOfWeek = {
            SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    };

    public static int getCurrentDay() {
        return daysOfWeek[dayIndex] - 1;
    }
    public static void nextDay() {
        dayIndex = (dayIndex + 1) % daysOfWeek.length;
    }
    public static void setDay(int day) {
        dayIndex = day;
    }
}
