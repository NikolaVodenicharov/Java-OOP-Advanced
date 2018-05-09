package factories;

import models.centers.EmergencyCenter;

public interface EmergencyCenterFactory{
    EmergencyCenter create(String fullTypeName, String name, String processEmergencyLeft);
}
