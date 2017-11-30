import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        Container<Integer> elements = readStringElements(reader);

        Integer[] indexes =
                Arrays.stream(
                        reader
                                .readLine()
                                .split("\\s+"))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
        int index1 = indexes[0];
        int index2 = indexes[1];
        elements.reposition(index1, index2);

        System.out.println(elements);
    }

    public static Container<Integer> readStringElements(BufferedReader reader) throws IOException {
        Container<Integer> elements = new Container(new ArrayList<String>());

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            elements.addElement(Integer.parseInt(reader.readLine()));
        }

        return elements;
    }
}
