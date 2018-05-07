package models.emergencies;

import models.emergencies.Enums.EmergencyLevel;
import models.emergencies.Utils.RegistrationTime;

public class PropertyEmergency extends EmergencyImpl {

    private int propertyDamage;

    public PropertyEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            int damagedProperties) {
        super(description, emergencyLevel, registrationTime);
        setPropertyDamage(damagedProperties);
    }

    @Override
    public int specificInfo() {
        return propertyDamage;
    }

    private void setPropertyDamage(int propertyDamage){

        if (propertyDamage < 0){
            throw new IllegalArgumentException("Property damage can not be negative number.");
        }

        this.propertyDamage = propertyDamage;
    }
}
