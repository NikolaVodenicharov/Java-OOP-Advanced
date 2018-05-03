package models.abstractions;

import models.concreteClasses.RegistrationTime;
import models.enums.EmergencyLevel;

public interface Emergency {
    String getDescription();
    EmergencyLevel getEmergencyLevel();
    RegistrationTime getRegistrationTime();
}
