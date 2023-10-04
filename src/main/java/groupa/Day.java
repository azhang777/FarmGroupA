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

    public static String returnDayAsString(int dayNum) {
        String dayString = "";
        switch (dayNum) {
            case 0:
                dayString = "Sunday";
                break;
            case 1:
                dayString = "Monday";
                break;
            case 2:
                dayString = "Tuesday";
                break;
            case 3:
                dayString = "Wednesday";
                break;
            case 4:
                dayString = "Thursday";
                break;
            case 5:
                dayString = "Friday";
                break;
            case 6:
                dayString = "Saturday";
                break;
            default:
                dayString = "Sunday";
                break;
        }
        return dayString;
    }
}
