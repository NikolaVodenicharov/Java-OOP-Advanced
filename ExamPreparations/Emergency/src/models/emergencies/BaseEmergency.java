package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public abstract class BaseEmergency implements Emergency {

    private String description;
    private EmergencyLevel emergencyLevel;
    private RegistrationTime registrationTime;

    BaseEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime) {
        this.setDescription(description);
        this.emergencyLevel = emergencyLevel;
        this.registrationTime = registrationTime;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
    @Override
    public EmergencyLevel getEmergencyLevel() {
        return this.emergencyLevel;
    }
    @Override
    public RegistrationTime getRegistrationTime() {
        return this.registrationTime;
    }

    private void setDescription(String description) {
        if (description.length() < 3){
            throw new IllegalArgumentException("Description can not be less than 3 symbols");
        }

        this.description = description;
    }
}
