package models.emergencies;

import models.emergencies.Enums.EmergencyLevel;
import models.emergencies.Utils.RegistrationTime;

public interface Emergency {
    String getDescription();
    EmergencyLevel getEmergencyLevel();
    RegistrationTime getRegistrationTime();
    int specificInfo();
}
