package core.abstractions;

public interface CommandInterpreter {
    Executable interpret(String... data);
}
