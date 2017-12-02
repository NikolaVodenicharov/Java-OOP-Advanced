import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        // if o1 or o2 are null ?

        int result = o1.getName().length() - o2.getName().length();

        if (result == 0){
            result = o1.getName().toLowerCase().charAt(0) - o2.getName().toLowerCase().charAt(0);
        }

        return result;
    }
}
