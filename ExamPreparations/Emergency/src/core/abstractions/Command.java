package core.abstractions;

public abstract class Command implements Executable {
    public abstract String execute(String... args);
}
