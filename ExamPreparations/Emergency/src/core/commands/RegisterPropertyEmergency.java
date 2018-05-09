package core.commands;

import annotations.InjectArgs;
import annotations.InjectFactory;
import core.managers.EmergencyManagementSystem;
import factories.EmergencyFactory;
import models.emergencies.Emergency;

public class RegisterPropertyEmergency extends Command {
    private static final String FULL_NAME = "models.emergencies.PropertyEmergency";

    @InjectFactory
    private EmergencyFactory factory;
    @InjectArgs
    private String[] arguments;

    public RegisterPropertyEmergency(EmergencyManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute() {
        Emergency emergency = this.factory.create(FULL_NAME, this.arguments[0], this.arguments[1], this.arguments[2], this.arguments[3]);
        String message = this.getEmergencyManagementSystem().registerPropertyEmergency(emergency);

        return message;
    }
}
