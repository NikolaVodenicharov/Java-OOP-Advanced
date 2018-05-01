package models.concreteClasses.emergencies;

import models.abstractions.Emergency;
import models.enums.EmergencyLevel;
import models.concreteClasses.RegistrationTime;

public class PropertyEmergency extends Emergency {

    private int propertyDamage;

    public PropertyEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            int damagedProperties) {
        super(description, emergencyLevel, registrationTime);
        setPropertyDamage(damagedProperties);
    }

    private void setPropertyDamage(int propertyDamage){

        if (propertyDamage < 0){
            throw new IllegalArgumentException("Property damage can not be negative number.");
        }

        this.propertyDamage = propertyDamage;
    }
}
