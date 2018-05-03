package factories.abstractions;

import models.abstractions.Emergency;
import models.concreteClasses.RegistrationTime;
import models.enums.EmergencyLevel;

public interface EmergencyFactory {
    Emergency create(String fullTypeName, String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime);
}
