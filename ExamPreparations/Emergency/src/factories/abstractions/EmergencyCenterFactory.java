package factories.abstractions;

import models.abstractions.EmergencyCenter;

public interface EmergencyCenterFactory{
    EmergencyCenter create(String fullTypeName, String name, Integer emergencyLeft);
}
