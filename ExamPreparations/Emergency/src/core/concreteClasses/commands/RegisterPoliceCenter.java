package core.concreteClasses.commands;

import annotations.Inject;
import core.abstractions.Command;
import data.abstractions.EmergencyCenterRegister;
import factories.abstractions.EmergencyCenterFactory;
import models.abstractions.EmergencyCenter;

public class RegisterPoliceCenter extends Command {
    private static final String FULL_NAME = "models.concreteClasses.emergencyCenters.PoliceCenter";
    private static final String MESSAGE = "Registered Police Service Emergency center – %s.";

    @Inject
    private EmergencyCenterRegister register;
    @Inject
    private EmergencyCenterFactory factory;

    @Override
    public String execute(String... args) {
        String name = args[0];
        Integer emergencyLeft = Integer.parseInt(args[1]);

        EmergencyCenter center = factory.create(FULL_NAME, name, emergencyLeft);
        register.enqueueCenter(center);

        String output = String.format(MESSAGE, name);

        return output;
    }
}
