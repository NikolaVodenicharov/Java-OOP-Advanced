package factories;

import models.concreteClasses.RegistrationTime;
import models.enums.EmergencyLevel;

public interface EmergencyFactory {
    Object create(String typeFullName, String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime);
}
