package engines;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Runnable {
    void run() throws IOException, InvocationTargetException, IllegalAccessException;
}
