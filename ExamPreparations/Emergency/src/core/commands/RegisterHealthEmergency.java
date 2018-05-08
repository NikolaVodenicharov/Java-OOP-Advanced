package core.commands;

import annotations.InjectArgs;
import annotations.InjectFactory;
import core.managers.EmergencyManagementSystem;
import factories.EmergencyFactory;
import models.emergencies.Emergency;

public class RegisterHealthEmergency extends Command {
    private static final String FULL_NAME = "models.emergencies.HealthEmergency";

    @InjectFactory
    private EmergencyFactory factory;
    @InjectArgs
    private String[] arguments;

    public RegisterHealthEmergency(EmergencyManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }


    @Override
    public String execute() {
        Emergency emergency = this.factory.create(FULL_NAME, this.arguments[0], this.arguments[1], this.arguments[2]);
        String message = this.getEmergencyManagementSystem().registerHealthEmergency(emergency);

        return message;
    }
}
