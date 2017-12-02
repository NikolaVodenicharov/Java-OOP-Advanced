import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Person> people = readPeople(reader);

        int targetPersonNumber = Integer.parseInt(reader.readLine());
        Person targetPerson = people.get(targetPersonNumber - 1);

        int equalPeople = getEqualPeople(people, targetPerson);

        printAnswer(people, equalPeople);
    }

    private static List<Person> readPeople(BufferedReader reader) throws IOException {
        List<Person> people = new ArrayList<>();

        while(true){
            String inputLine = reader.readLine();

            if (inputLine == null || inputLine.trim().length() == 0){
                throw new IllegalArgumentException("Input can not be null or empty");
            }

            boolean isBreak = inputLine.equals("END");
            if (isBreak){
                break;
            }

            String[] arguments = inputLine.split("\\s+");
            Person person = createPerson(arguments);
            people.add(person);
        }

        return people;
    }
    private static Person createPerson(String[] parameters){
        String name = parameters[0];
        int age = Integer.parseInt(parameters[1]);
        String town = parameters[2];

        Person person = new Person(name, age, town);

        return person;
    }

    private static int getEqualPeople(List<Person> people, Person targetPerson) {
        int equalPeople = 0;
        for (Person person : people) {
            if (targetPerson.compareTo(person) == 0){
                equalPeople++;
            }
        }

        if (equalPeople == 1){
            equalPeople = 0;
        }

        return equalPeople;
    }

    private static void printAnswer(List<Person> people, int equalPeople) {
        if (equalPeople != 0){
            int totalPeople = people.size();
            int notEqualPeople = totalPeople - equalPeople;

            System.out.println(equalPeople + " " + notEqualPeople + " " + totalPeople);
        }
        else{
            System.out.println("No matches");
        }
    }
}
