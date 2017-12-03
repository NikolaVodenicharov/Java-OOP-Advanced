import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WeeklyCalendar weeklyCalendar = new WeeklyCalendar(new ArrayList<>());
        weeklyCalendar.addEntry("Friday", "sleep");
        weeklyCalendar.addEntry("Monday", "sport");
        Iterable<WeeklyEntry> schedule = weeklyCalendar.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}
