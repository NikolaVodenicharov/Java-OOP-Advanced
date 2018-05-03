package data.abstractions;

import models.abstractions.EmergencyCenter;

public interface EmergencyCenterRegister {
    void enqueueEmergency(EmergencyCenter center);
    EmergencyCenter dequeueEmergency();
    EmergencyCenter peekEmergency();
    Boolean isEmpty();
}
