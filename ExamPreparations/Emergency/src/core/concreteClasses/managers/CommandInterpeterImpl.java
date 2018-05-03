package core.concreteClasses.managers;

import core.abstractions.CommandInterpreter;
import core.abstractions.Executable;
import factories.abstractions.EmergencyFactory;

public class CommandInterpeterImpl implements CommandInterpreter {

    private EmergencyFactory emergencyFactory;

    public CommandInterpeterImpl(EmergencyFactory emergencyFactory) {
        this.emergencyFactory = emergencyFactory;
    }

    @Override
    public Executable interpret(String[] data) {


        Executable command = null;

        return command;
    }
}
