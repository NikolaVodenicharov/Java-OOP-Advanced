import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Box<Integer> box =
                    new Box<>(
                    Integer.parseInt(
                            reader.readLine()));

            System.out.println(box.toString());
        }
    }
}
