package groupa;

import static java.util.Calendar.*;

public enum Day {
    INSTANCE;
    private static int dayIndex = 0;

    /**
     * Day contains a daysOfWeek static field of int[] that represents each day
     * as int form
     */
    private static final int[] daysOfWeek = {
            SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    };

    /**
     * @return
     * make sure day index is always between 0-6 and not starting at 1
     */
    public static int getCurrentDay() {
        return daysOfWeek[dayIndex] - 1;
    }

    /**
     * if day index = 7, it will be reset back to 0 (Sunday)
     */
    public static void nextDay() {
        dayIndex = (dayIndex + 1) % daysOfWeek.length;
    }
    public static void setDay(int day) {
        dayIndex = day;
    }

    /**
     *
     * @param dayNum
     * @return
     * used to return day as String, used in WeeklySchedule
     */
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
