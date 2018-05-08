package core.commands;

import annotations.InjectType;
import core.managers.EmergencyManagementSystem;

public class ProcessEmergencies extends Command {
    @InjectType
    private String emergencyType;

    public ProcessEmergencies(EmergencyManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute() {
        String message = this.getEmergencyManagementSystem().processEmergencies(emergencyType);
        return message;
    }
}