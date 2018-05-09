package commands;

import annotations.InjectType;
import core.ManagementSystem;

public class ProcessEmergenciesCommand extends BaseCommand {
    @InjectType
    private String emergencyType;

    public ProcessEmergenciesCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String message = this.getManagementSystem().processEmergencies(emergencyType);
        return message;
    }
}