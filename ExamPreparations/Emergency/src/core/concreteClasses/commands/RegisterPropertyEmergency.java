package core.concreteClasses.commands;

import annotations.InjectArgs;
import core.abstractions.Command;
import core.abstractions.EmergencyManagementSystem;
import factories.EmergencyFactory;
import models.emergencies.Emergency;

public class RegisterPropertyEmergency extends Command {
    private static final String FULL_NAME = "models.emergencies.PropertyEmergency";

    @InjectArgs
    private EmergencyManagementSystem emergencyManagementSytem;
    @InjectArgs
    private EmergencyFactory factory;

    @Override
    public String execute(String... args) {
        Emergency emergency = factory.create(FULL_NAME, args[0], args[1], args[2]);
        String message = emergencyManagementSytem.registerPropertyEmergency(emergency);

        return message;
    }
}
