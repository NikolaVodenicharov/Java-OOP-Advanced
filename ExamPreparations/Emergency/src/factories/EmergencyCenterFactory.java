package factories;

import models.emergencyCenters.EmergencyCenter;

public interface EmergencyCenterFactory{
    EmergencyCenter create(String fullTypeName, String name, Integer emergencyLeft);
}
