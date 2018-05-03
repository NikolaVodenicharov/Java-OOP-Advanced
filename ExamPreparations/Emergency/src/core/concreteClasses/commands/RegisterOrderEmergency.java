package core.concreteClasses.commands;

import annotations.Inject;
import core.abstractions.Command;
import data.abstractions.EmergencyRegister;
import factories.abstractions.EmergencyFactory;
import models.abstractions.Emergency;
import models.concreteClasses.RegistrationTime;
import models.enums.EmergencyLevel;

public class RegisterOrderEmergency extends Command {
    private static final String FULL_NAME = "models.concreteClasses.emergencies.OrderEmergency";
    private static final String MESSAGE = "Registered Public Order Emergency of level %s at %s.";

    @Inject
    private EmergencyRegister register;
    @Inject
    private EmergencyFactory factory;


    @Override
    public String execute(String... args) {
        String description = args[0];
        EmergencyLevel level = EmergencyLevel.valueOf(args[1].toUpperCase());
        RegistrationTime time = new RegistrationTime(args[2]);

        Emergency emergency = factory.create(FULL_NAME, description, level, time);
        register.enqueueEmergency(emergency);

        String output = String.format(MESSAGE, level, time);

        return output;
    }
}
