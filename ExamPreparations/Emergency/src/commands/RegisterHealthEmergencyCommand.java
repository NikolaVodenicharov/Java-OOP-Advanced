package commands;

import annotations.InjectArgs;
import annotations.InjectFactory;
import core.ManagementSystem;
import factories.EmergencyFactory;
import models.emergencies.Emergency;

public class RegisterHealthEmergencyCommand extends BaseCommand {
    private static final String FULL_NAME = "models.emergencies.HealthEmergency";

    @InjectFactory
    private EmergencyFactory factory;
    @InjectArgs
    private String[] arguments;

    public RegisterHealthEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }


    @Override
    public String execute() {
        Emergency emergency = this.factory.create(FULL_NAME, this.arguments[0], this.arguments[1], this.arguments[2], this.arguments[3]);
        String message = this.getManagementSystem().registerHealthEmergency(emergency);

        return message;
    }
}
