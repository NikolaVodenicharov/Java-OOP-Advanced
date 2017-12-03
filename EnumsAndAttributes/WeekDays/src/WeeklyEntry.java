import java.util.Comparator;

public class WeeklyEntry {
    public static final Comparator<WeeklyEntry> COMPARE_BY_WEEKDAY = getComparatorByWeekday();

    private Weekday weekday;
    private String note;

    public WeeklyEntry(String weekday, String note) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.note = note;
    }

    @Override
    public String toString(){
        String formatted =
                String.format(
                        "%s - %s",
                        this.weekday,
                        this.note);


        return formatted;
    }

    private static Comparator<WeeklyEntry> getComparatorByWeekday() {
        return Comparator.comparingInt(e -> e.weekday.ordinal());
    }
}
