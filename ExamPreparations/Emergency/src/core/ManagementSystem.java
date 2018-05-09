package core;

import models.emergencies.Emergency;
import models.centers.EmergencyCenter;

public interface ManagementSystem {

    String registerPropertyEmergency(Emergency emergency);
    String registerHealthEmergency(Emergency emergency);
    String registerOrderEmergency(Emergency emergency);

    String registerFireServiceCenter(EmergencyCenter center);
    String registerMedicalServiceCenter(EmergencyCenter center);
    String registerPoliceServiceCenter(EmergencyCenter center);

    String processEmergencies(String emergencyType);
    String emergencyReport();
}
