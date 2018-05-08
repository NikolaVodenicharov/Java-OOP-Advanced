package core.commands;

import annotations.InjectArgs;
import annotations.InjectFactory;
import core.managers.EmergencyManagementSystem;
import factories.EmergencyCenterFactory;
import models.emergencyCenters.EmergencyCenter;

public class RegisterFireServiceCenter extends Command {
    private static final String FULL_NAME = "models.emergencyCenters.FireServiceCenter";

    @InjectFactory
    private EmergencyCenterFactory factory;
    @InjectArgs
    private String[] arguments;

    public RegisterFireServiceCenter(EmergencyManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute() {
        EmergencyCenter center = this.factory.create(FULL_NAME, this.arguments[0], this.arguments[1]);
        String message = this.getEmergencyManagementSystem().registerFireServiceCenter(center);

        return message;
    }
}
