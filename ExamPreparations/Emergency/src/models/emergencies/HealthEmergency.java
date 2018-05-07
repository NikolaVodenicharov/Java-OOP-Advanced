package models.emergencies;

import models.emergencies.Enums.EmergencyLevel;
import models.emergencies.Utils.RegistrationTime;

public class HealthEmergency extends EmergencyImpl {

    private int casualtiesCount;

    public HealthEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            int casualtiesCount) {
        super(description, emergencyLevel, registrationTime);
        setCasualtiesCount(casualtiesCount);
    }

    private void setCasualtiesCount(int casualtiesCount){

        if (casualtiesCount < 0){
            throw new IllegalArgumentException("Casualties can not be negative number.");
        }

        this.casualtiesCount = casualtiesCount;
    }

    @Override
    public int specificInfo() {
        return casualtiesCount;
    }
}
