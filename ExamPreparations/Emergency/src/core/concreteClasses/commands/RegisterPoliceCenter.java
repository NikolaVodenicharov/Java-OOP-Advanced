package core.concreteClasses.commands;

import annotations.InjectArgs;
import core.abstractions.Command;
import core.abstractions.EmergencyManagementSystem;
import factories.EmergencyCenterFactory;
import models.emergencyCenters.EmergencyCenter;

public class RegisterPoliceCenter extends Command {
    private static final String FULL_NAME = "models.emergencyCenters.PoliceServiceCenter";


    @InjectArgs
    private EmergencyManagementSystem emergencyManagementSytem;
    @InjectArgs
    private EmergencyCenterFactory factory;

    @Override
    public String execute(String... args) {
        EmergencyCenter center = factory.create(FULL_NAME, args[0], args[1]);
        String message = emergencyManagementSytem.registerPoliceServiceCenter(center);

        return message;
    }
}
