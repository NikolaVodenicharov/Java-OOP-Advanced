package factories;

import models.emergencies.Emergency;
import models.emergencies.Utils.RegistrationTime;
import models.emergencies.Enums.EmergencyLevel;

public interface EmergencyFactory {
    Emergency create(String fullTypeName, String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime);
}
