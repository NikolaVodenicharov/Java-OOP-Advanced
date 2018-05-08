package core.concreteClasses.commands;

import annotations.InjectArgs;
import core.abstractions.Command;
import core.abstractions.EmergencyManagementSystem;
import factories.EmergencyFactory;
import models.emergencies.Emergency;

public class RegisterOrderEmergency extends Command {
    private static final String FULL_NAME = "models.emergencies.OrderEmergency";


    @InjectArgs
    private EmergencyManagementSystem emergencyManagementSytem;
    @InjectArgs
    private EmergencyFactory factory;



    @Override
    public String execute(String... args) {
        Emergency emergency = this.factory.create(FULL_NAME, args[0], args[1], args[2]);
        String message = this.emergencyManagementSytem.registerOrderEmergency(emergency);

        return message;
    }
}
