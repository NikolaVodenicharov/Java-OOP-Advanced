package core.commands;

import annotations.InjectArgs;
import core.managers.EmergencyManagementSystem;
import factories.EmergencyFactory;
import models.emergencies.Emergency;

public abstract class EmergencyCommand extends Command {

    @InjectArgs
    protected EmergencyFactory factory;
    @InjectArgs
    protected String[] arguments;

    protected EmergencyCommand(EmergencyManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    public String registerEmergency(String fullName){
        Emergency emergency = this.factory.create(fullName, this.arguments[0], this.arguments[1], this.arguments[2]);
        String message = this.getEmergencyManagementSystem().registerPropertyEmergency(emergency);

        return message;
    }
}
