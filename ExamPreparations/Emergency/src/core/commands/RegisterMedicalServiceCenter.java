package core.commands;

import annotations.InjectArgs;
import annotations.InjectFactory;
import core.managers.EmergencyManagementSystem;
import factories.EmergencyCenterFactory;
import models.emergencyCenters.EmergencyCenter;

public class RegisterMedicalServiceCenter extends Command {
    private static final String FULL_NAME = "models.emergencyCenters.MedicalServiceCenter";

    @InjectFactory
    private EmergencyCenterFactory factory;
    @InjectArgs
    private String[] arguments;

    public RegisterMedicalServiceCenter(EmergencyManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute() {
        EmergencyCenter center = this.factory.create(FULL_NAME, this.arguments[0], this.arguments[1]);
        String message = this.getEmergencyManagementSystem().registerMedicalServiceCenter(center);

        return message;
    }
}
