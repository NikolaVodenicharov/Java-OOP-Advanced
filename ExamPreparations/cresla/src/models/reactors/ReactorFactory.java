package models.reactors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReactorFactory {
    private static final String REACTOR_PATH = "models.reactors";

    public Reactor create(int id, String reactorSimpleName, int additionalParameter, int moduleCapacity){
        String fullName = REACTOR_PATH + "." + reactorSimpleName;

        Reactor reactor = null;

        try {
            Class clazz = Class.forName(fullName);
            Constructor constructor = clazz.getDeclaredConstructors()[0];
            reactor = (Reactor) constructor.newInstance(id, additionalParameter, moduleCapacity);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return reactor;
    }
}
