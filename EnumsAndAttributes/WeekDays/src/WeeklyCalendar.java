import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WeeklyCalendar{
    private List<WeeklyEntry> weeklyEntries;

    public WeeklyCalendar(List<WeeklyEntry> weeklyEntries){
        this.weeklyEntries = weeklyEntries;
    }

    public void addEntry(String weekday, String note){
        WeeklyEntry weeklyEntry = new WeeklyEntry(weekday, note);
        this.weeklyEntries.add(weeklyEntry);
    }

    public Iterable<WeeklyEntry> getWeeklySchedule(){
        Collections.sort(this.weeklyEntries, WeeklyEntry.COMPARE_BY_WEEKDAY);

        return this.weeklyEntries;
    }
}
