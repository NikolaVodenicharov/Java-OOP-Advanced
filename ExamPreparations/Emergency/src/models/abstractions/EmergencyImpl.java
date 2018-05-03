package models.abstractions;

import models.enums.EmergencyLevel;
import models.concreteClasses.RegistrationTime;

public abstract class EmergencyImpl implements Emergency {

    private String description;
    private EmergencyLevel emergencyLevel;
    private RegistrationTime registrationTime;

    public EmergencyImpl(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);
    }

    @Override
    public String getDescription() {
        return description;
    }
    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }
    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    @Override
    public RegistrationTime getRegistrationTime() {
        return registrationTime;
    }
    private void setRegistrationTime(RegistrationTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
