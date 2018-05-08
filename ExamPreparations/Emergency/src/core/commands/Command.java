package core.commands;

import core.managers.EmergencyManagementSystem;

public abstract class Command implements Executable {
    private EmergencyManagementSystem emergencyManagementSystem;

    protected Command (EmergencyManagementSystem emergencyManagementSystem)
    {
        this.emergencyManagementSystem = emergencyManagementSystem;
    }

    protected EmergencyManagementSystem getEmergencyManagementSystem(){
        return this.emergencyManagementSystem;
    }
}
