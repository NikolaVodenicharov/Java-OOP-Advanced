package factories;

import models.emergencies.Emergency;

public interface EmergencyFactory {
    Emergency create(String fullTypeName, String description, String emergencyLevel, String registrationTime, String specialInfo);
}
