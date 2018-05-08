package core.commands;

import core.managers.EmergencyManagementSystem;

public class EmergencyReport extends Command {
    public EmergencyReport(EmergencyManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute() {
        String message = this.getEmergencyManagementSystem().emergencyReport();
        return message;
    }
}
