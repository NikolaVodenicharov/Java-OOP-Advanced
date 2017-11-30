import Implementations.CustomListImpl;
import Interfaces.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        CustomList<String> elements = new CustomListImpl<>();

        while(true){
            String inputLine = reader.readLine();

            boolean isNull = inputLine == null;
            if (isNull){
                throw new NullPointerException("Input line was null.");
            }

            boolean isBreak = "END".equals(inputLine);
            if (isBreak){
                break;
            }

            String[] parameters = inputLine.split("\\s+");

            commandInterpreter(elements, parameters);
        }
    }

    public static void commandInterpreter(CustomList<String> elements, String[] parameters){
        String command = parameters[0];

        switch(command){
            case "Add":
                String addingElement = parameters[1];
                elements.add(addingElement);
                break;
            case "Remove":
                int elementIndex = Integer.parseInt(parameters[1]);
                elements.remove(elementIndex);
                break;
            case "Contains":
                String containingElement = parameters[1];
                System.out.println(elements.contains(containingElement));
                break;
            case "Swap":
                int index1 = Integer.parseInt(parameters[1]);
                int index2 = Integer.parseInt(parameters[2]);
                elements.swap(index1, index2);
                break;
            case "Greater":
                String targetElement = parameters[1];
                System.out.println(elements.countGreaterThat(targetElement));
                break;
            case "Max":
                System.out.println(elements.getMax());
                break;
            case "Min":
                System.out.println(elements.getMin());
                break;
            case "Print":
                System.out.println(elements);
                break;
            default:
                break;
        }
    }
}
