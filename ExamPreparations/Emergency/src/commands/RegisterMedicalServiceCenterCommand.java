package commands;

import annotations.InjectArgs;
import annotations.InjectFactory;
import core.ManagementSystem;
import factories.EmergencyCenterFactory;
import models.centers.EmergencyCenter;

public class RegisterMedicalServiceCenterCommand extends BaseCommand {
    private static final String FULL_NAME = "models.centers.MedicalServiceCenter";

    @InjectFactory
    private EmergencyCenterFactory factory;
    @InjectArgs
    private String[] arguments;

    public RegisterMedicalServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        EmergencyCenter center = this.factory.create(FULL_NAME, this.arguments[0], this.arguments[1]);
        String message = this.getManagementSystem().registerMedicalServiceCenter(center);

        return message;
    }
}
