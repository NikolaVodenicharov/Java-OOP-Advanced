package core.concreteClasses.managers;

import core.abstractions.CommandInterpreter;
import core.abstractions.Executable;

import java.lang.reflect.Constructor;

public class CommandInterpeterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE_PATH = "core.concreteClasses.command";

    @Override
    public Executable interpret(String... data) {
        String commandName = data[0];
        String fullName = COMMAND_PACKAGE_PATH + "." + commandName;
        Executable command = null;

        try {
            Class clazz = Class.forName(fullName);
            Constructor constructor = clazz.getDeclaredConstructor();
            command = (Executable) constructor.newInstance();

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return command;
    }
}
