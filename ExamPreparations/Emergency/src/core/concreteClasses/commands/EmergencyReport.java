package core.concreteClasses.commands;

import annotations.InjectArgs;
import core.abstractions.Command;
import core.abstractions.EmergencyManagementSystem;

public class EmergencyReport extends Command {

    @InjectArgs
    private EmergencyManagementSystem emergencyManagementSytem;

    @Override
    public String execute(String... args) {
        String message = this.emergencyManagementSytem.emergencyReport();

        return message;
    }
}
