package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.*;

import java.lang.reflect.Constructor;

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
            Constructor constructor = commandClass.getConstructor(String[].class, Repository.class, UnitFactory.class);
            command = (Executable) constructor.newInstance(data, repository, unitFactory);

            return command;
        }
        catch(ReflectiveOperationException e){
            e.printStackTrace();
        }

        return command;
    }

    private static String toTitleCase(String word) {
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
}
