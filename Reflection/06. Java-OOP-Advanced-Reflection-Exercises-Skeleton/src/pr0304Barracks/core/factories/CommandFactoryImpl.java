package pr0304Barracks.core.factories;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandFactoryImpl implements CommandFactory {
    private static final String COMMANDS_PACKAGE_NAME = "pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandFactoryImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable createCommand(String[] data) {
        String commandType = data[0];
        String titleCaseCommand = toTitleCase(commandType);

        Executable command = null;


        try{
            String fullName = COMMANDS_PACKAGE_NAME + titleCaseCommand;
            Class commandClass = Class.forName(fullName);
            Constructor constructor = commandClass.getConstructor(String[].class);
            command = (Executable) constructor.newInstance((Object)data);
            injectDependency(commandClass, command);

            return command;
        }
        catch(ReflectiveOperationException e){
            e.printStackTrace();
        }

        return command;
    }

    private String toTitleCase(String word) {
        StringBuilder titleCase = new StringBuilder();
        char[] characters = word.toCharArray();

        char firstChar = characters[0];
        char upperCaseChar = Character.toUpperCase(firstChar);

        titleCase.append(upperCaseChar);

        for (int i = 1; i < characters.length; i++) {
            char character = characters[i];
            char lowerCaseChar = Character.toLowerCase(character);

            titleCase.append(lowerCaseChar);
        }

        return titleCase.toString();
    }
    private void injectDependency(Class commandClass, Executable command) throws IllegalAccessException {
        Field[] factoryFields = CommandFactoryImpl.class.getDeclaredFields();
        Field[] commandFields = commandClass.getDeclaredFields();

        for (Field commandField : commandFields) {
            if (!commandField.isAnnotationPresent(Inject.class)){
                continue;
            }

            commandField.setAccessible(true);

            for (Field factoryField : factoryFields) {
                if (!factoryField.getType().equals(commandField.getType())){
                    continue;
                }

                factoryField.setAccessible(true);
                commandField.set(command, factoryField.get(this));
                break;
            }
        }
    }
}
