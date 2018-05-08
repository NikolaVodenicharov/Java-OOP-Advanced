package core.managers;

import core.commands.Executable;

public interface CommandInterpreter {
    Executable interpret(String[] arguments);
}
