package core.concreteClasses.commands;

import annotations.InjectArgs;
import annotations.InjectType;
import core.abstractions.Command;
import core.abstractions.EmergencyManagementSystem;

public class ProcessEmergencies extends Command {

    @InjectType
    private String emergencyType;
    @InjectArgs
    private EmergencyManagementSystem emergencyManagementSytem;


    @Override
    public String execute(String... args) {
        String message = this.emergencyManagementSytem.processEmergencies(emergencyType);

        return message;
    }
}