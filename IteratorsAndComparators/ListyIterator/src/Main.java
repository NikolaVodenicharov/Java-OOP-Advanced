import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<String> arguments = readListyIteratorArguments(reader);
        ListyIterator<String> elements = createListyIterator(arguments);
        executeInputCommands(reader, elements);
    }

    private static List<String> readListyIteratorArguments(BufferedReader reader) throws IOException{
        String[] inputArguments = reader.readLine().split("\\s+");
        List<String> arguments =
                Arrays.stream(inputArguments)
                        .skip(1)
                        .limit(inputArguments.length - 1)
                        .collect(Collectors.toList());

        return arguments;
    }
    private static ListyIterator<String> createListyIterator(List<String> parameters){
        ListyIterator<String> elements = new ListyIterator<>(parameters);
        return elements;
    }
    private static <T> void executeInputCommands(BufferedReader reader, ListyIterator<T> elements) throws IOException{
        try {
            while (true) {
                String command = reader.readLine();

                boolean isBreak = "END".equals(command);
                if (isBreak) {
                    break;
                }

                commandInterpreter(command, elements);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static <T> void commandInterpreter(String command, ListyIterator<T> elements){
        switch (command) {
            case "Move":
                System.out.println(elements.Move());
                break;
            case "Print":
                elements.print();
                break;
            case "HasNext":
                System.out.println(elements.hasNext());
                break;
            default:
                break;
        }
    }
}
