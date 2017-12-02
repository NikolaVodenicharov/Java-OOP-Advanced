import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        TreeSet<Person> nameSortedPeople = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> ageSortedPeople = new TreeSet<>(new PersonAgeComparator());

        Collection<Person> people = readPeople(reader);
        copyCollection(people, nameSortedPeople, ageSortedPeople);

        String output = formatOutputData(nameSortedPeople, ageSortedPeople);
        System.out.println(output);
    }

    private static Person createPerson(String[] parameters){
        String name = parameters[0];
        int age = Integer.parseInt(parameters[1]);

        Person person = new Person(name, age);

        return person;
    }
    private static Collection<Person> readPeople(BufferedReader reader) throws IOException {
        int inputLinesNumber = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>(inputLinesNumber);

        for (int i = 0; i < inputLinesNumber; i++) {
            String[] arguments = reader.readLine().split("\\s+");
            Person person = createPerson(arguments);
            people.add(person);
        }

        return people;
    }

    private static <T> void copyCollection(Collection<T> source, Collection<T>... destinations) {
        for (T element : source) {
            for (Collection<T> destination : destinations) {
                destination.add(element);
            }
        }
    }

    private static String formatOutputData(TreeSet<Person> nameSortedPeople, TreeSet<Person> ageSortedPeople) {
        StringBuilder formatted = new StringBuilder();
        for (Person person : nameSortedPeople) {
            formatted
                    .append(person)
                    .append(System.lineSeparator());
        }
        for (Person person : ageSortedPeople) {
            formatted
                    .append(person)
                    .append(System.lineSeparator());
        }

        return formatted.toString().trim();
    }
}
