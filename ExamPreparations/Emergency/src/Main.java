import core.EmergencyManagementSystem;
import core.ManagementSystem;
import interpreters.Interpreter;
import interpreters.CommandInterpreter;
import engines.Engine;
import engines.Runnable;
import factories.EmergencyCenterFactory;
import factories.EmergencyCenterFactoryImpl;
import factories.EmergencyFactory;
import factories.EmergencyFactoryImpl;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.Reader;
import io.Writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException, InvocationTargetException {
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        EmergencyFactory emergencyFactory = new EmergencyFactoryImpl();
        EmergencyCenterFactory emergencyCenterFactory = new EmergencyCenterFactoryImpl();
        Interpreter interpreter = new CommandInterpreter(managementSystem, emergencyFactory, emergencyCenterFactory);

        Writer writer = new ConsoleWriter();

        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        Reader reader = new ConsoleReader(bufferedReader);

        Runnable engine = new Engine(interpreter, writer, reader);

        engine.run();
    }
}
