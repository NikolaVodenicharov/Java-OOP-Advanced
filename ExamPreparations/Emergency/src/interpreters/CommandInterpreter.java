package interpreters;

import annotations.InjectArgs;
import annotations.InjectFactory;
import annotations.InjectType;
import commands.Executable;
import core.ManagementSystem;
import factories.EmergencyCenterFactory;
import factories.EmergencyFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class CommandInterpreter implements Interpreter {
    private static final String COMMAND_PACKAGE_PATH = "commands";
    private static final String COMMAND_SUFFIX = "Command";

    private ManagementSystem managementSystem;
    private EmergencyFactory emergencyFactory;
    private EmergencyCenterFactory emergencyCenterFactory;

    public CommandInterpreter(
            ManagementSystem managementSystem,
            EmergencyFactory emergencyFactory,
            EmergencyCenterFactory emergencyCenterFactory){
        this.managementSystem = managementSystem;
        this.emergencyFactory = emergencyFactory;
        this.emergencyCenterFactory = emergencyCenterFactory;
    }

    @Override
    public Executable interpret(String[] arguments) {
        String commandName = arguments[0];
        String fullName = COMMAND_PACKAGE_PATH + "." + commandName + COMMAND_SUFFIX;
        Executable command = null;

        try {
            Class clazz = Class.forName(fullName);
            Constructor constructor = clazz.getDeclaredConstructor(ManagementSystem.class);
            command = (Executable) constructor.newInstance(this.managementSystem);
            commandInjection(command, arguments);

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return command;
    }

    private void commandInjection(Executable command, String[] arguments) throws IllegalAccessException {
        Field[] fields = command.getClass().getDeclaredFields();
        Field[] interpreterFields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectFactory.class)){
                injectFactory(command, interpreterFields, field);
            }
            else if (field.isAnnotationPresent(InjectArgs.class)){
                injectArguments(command, arguments, field);
            }
            else if (field.isAnnotationPresent(InjectType.class)){
                injectType(command, arguments, field);
            }
        }
    }
    private void injectFactory(Executable command, Field[] interpreterFields, Field field) throws IllegalAccessException {
        for (Field interpreterField : interpreterFields) {
            if (field.getType().equals(interpreterField.getType())){
                field.setAccessible(true);
                interpreterField.setAccessible(true);
                field.set(command, interpreterField.get(this));
                break;
            }
        }
    }
    private void injectArguments(Executable command, String[] arguments, Field field) throws IllegalAccessException {
        if (arguments.length <= 2){
            throw new IllegalArgumentException("Not enough input arguments. Need minimum 3");
        }

        String[] commandArguments = Arrays.copyOfRange(arguments, 1, arguments.length);
        field.setAccessible(true);
        field.set(command, commandArguments);
    }
    private void injectType(Executable command, String[] arguments, Field field) throws IllegalAccessException {
        if (arguments.length <= 1){
            throw new IllegalArgumentException("Not enough input arguments. Need minimum 2");
        }

        String type = arguments[1];
        field.setAccessible(true);
        field.set(command, type);
    }
}
