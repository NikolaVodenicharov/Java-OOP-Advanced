import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        String inputLine = reader.readLine();
        if(inputLine !=null && inputLine.trim().length() > 0){
            Integer[] numbers =
                    Arrays.stream(
                            inputLine.split("[, ]+"))
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new);

            Lake lake = new Lake(Arrays.asList(numbers));

            String iteratedLake = getFormattedCollection(lake);
            System.out.println(iteratedLake);
        }

    }

    private static String getFormattedCollection(Lake lake){
        StringBuilder formatted = new StringBuilder();
        for (Integer integer : lake) {
            formatted
                    .append(integer)
                    .append(", ");
        }
        formatted.delete(formatted.length()-2, formatted.length());

        return formatted.toString();
    }
}
