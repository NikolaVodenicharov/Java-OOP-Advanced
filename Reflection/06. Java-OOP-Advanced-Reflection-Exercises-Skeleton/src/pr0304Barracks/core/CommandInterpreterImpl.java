package pr0304Barracks.core;

import pr0304Barracks.contracts.*;
import pr0304Barracks.core.factories.CommandFactoryImpl;

import java.lang.reflect.Array;

public class CommandInterpreterImpl implements CommandInterpreter {

    private CommandFactory commandFactory;

    public CommandInterpreterImpl(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public Executable interpretCommand(String[] data) {
        Executable command = commandFactory.createCommand(data);
        return command;
    }
}
