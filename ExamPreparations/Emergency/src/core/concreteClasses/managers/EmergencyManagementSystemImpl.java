package core.concreteClasses.managers;

import data.abstractions.EmergencyCenterRegister;
import core.abstractions.EmergencyManagementSystem;
import data.abstractions.EmergencyRegister;

public class  EmergencyManagementSystemImpl implements EmergencyManagementSystem {
    private EmergencyRegister emergencyRegister;
    private EmergencyCenterRegister emergencyCenterRegister;

    public EmergencyManagementSystemImpl(EmergencyRegister emergencyRegister, EmergencyCenterRegister emergencyCenterRegister) {
        this.emergencyRegister = emergencyRegister;
        this.emergencyCenterRegister = emergencyCenterRegister;
    }

    public String registerPropertyEmergency() {
        return null;
    }
    public String registerHealthEmergency() {
        return null;
    }
    public String registerOrderEmergency() {
        return null;
    }

    public String registerFireServiceCenter() {
        return null;
    }
    public String registerMedicalServiceCenter() {
        return null;
    }
    public String registerPoliceServiceCenter() {
        return null;
    }

    public String processEmergencies() {
        return null;
    }
    public String emergencyReport() {
        return null;
    }
}
