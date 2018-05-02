package pr0304Barracks.contracts;

public interface CommandFactory {
    Executable createCommand(String[] data);
}
