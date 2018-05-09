package commands;

import core.ManagementSystem;

public class EmergencyReportCommand extends BaseCommand {
    public EmergencyReportCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String message = this.getManagementSystem().emergencyReport();
        return message;
    }
}
