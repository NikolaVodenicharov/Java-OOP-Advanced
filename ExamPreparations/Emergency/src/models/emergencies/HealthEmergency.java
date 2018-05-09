package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public class HealthEmergency extends BaseEmergency {

    private int casualtiesCount;

    public HealthEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            String casualtiesCount) {
        super(description, emergencyLevel, registrationTime);
        setCasualtiesCount(casualtiesCount);
    }

    private void setCasualtiesCount(String casualtiesCount){
        Integer parsedCasualtiesCount = Integer.valueOf(casualtiesCount);

        if (parsedCasualtiesCount < 0){
            throw new IllegalArgumentException("Casualties can not be negative number.");
        }

        this.casualtiesCount = parsedCasualtiesCount;
    }

    @Override
    public int specificInfo() {
        return casualtiesCount;
    }
}
