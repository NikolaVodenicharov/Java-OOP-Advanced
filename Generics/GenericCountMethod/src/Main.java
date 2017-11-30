import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Double> elements = readInputLines(reader);
        Double target = Double.parseDouble(reader.readLine());

        int count = countGreaterCount(elements, target);

        System.out.println(count);
    }

    public static List<Double> readInputLines(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Double> elements = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            elements.add(Double.parseDouble(reader.readLine()));
        }

        return elements;
    }

    public static <T extends Comparable<T>> Integer countGreaterCount(Collection<T> elements, T target){
        int counter = 0;

        for (T element : elements) {
            if (element.compareTo(target) > 0){
                counter++;
            }
        }

        return counter;
    }
}
