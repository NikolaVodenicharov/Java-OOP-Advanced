package core.concreteClasses.commands;

import annotations.InjectArgs;
import core.abstractions.Command;
import core.abstractions.EmergencyManagementSystem;
import factories.EmergencyCenterFactory;
import models.emergencyCenters.EmergencyCenter;

public class RegisterFireCenter extends Command {
    private static final String FULL_NAME = "models.emergencyCenters.FireServiceCenter";

    @InjectArgs
    private EmergencyManagementSystem emergencyManagementSytem;
    @InjectArgs
    private EmergencyCenterFactory factory;

    @Override
    public String execute(String... args) {
        EmergencyCenter center = this.factory.create(FULL_NAME, args[0], args[1]);
        String message = this.emergencyManagementSytem.registerFireServiceCenter(center);

        return message;
    }
}
