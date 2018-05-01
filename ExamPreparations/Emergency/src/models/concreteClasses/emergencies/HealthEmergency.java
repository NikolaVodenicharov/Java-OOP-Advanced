package models.concreteClasses.emergencies;

import models.abstractions.Emergency;
import models.enums.EmergencyLevel;
import models.concreteClasses.RegistrationTime;

public class HealthEmergency extends Emergency {

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
            throw new IllegalArgumentException("Damaged properties can not be negative number.");
        }

        this.casualtiesCount = casualtiesCount;
    }
}
