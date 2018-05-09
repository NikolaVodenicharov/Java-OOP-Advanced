package interpreters;

import commands.Executable;

public interface Interpreter {
    Executable interpret(String[] arguments);
}
