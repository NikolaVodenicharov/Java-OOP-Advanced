package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency {

    private int propertyDamage;

    public PropertyEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            String damagedProperties) {
        super(description, emergencyLevel, registrationTime);
        setPropertyDamage(damagedProperties);
    }

    @Override
    public int specificInfo() {
        return propertyDamage;
    }

    private void setPropertyDamage(String propertyDamage){

        Integer parsedPropertyDamage = Integer.valueOf(propertyDamage);

        if (parsedPropertyDamage < 0){
            throw new IllegalArgumentException("Property damage can not be negative number.");
        }

        this.propertyDamage = parsedPropertyDamage;
    }
}
