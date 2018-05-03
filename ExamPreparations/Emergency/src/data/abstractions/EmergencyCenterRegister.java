package data.abstractions;

import models.abstractions.EmergencyCenter;

public interface EmergencyCenterRegister {
    void enqueueCenter(EmergencyCenter center);
    EmergencyCenter dequeueCenter();
    EmergencyCenter peekCenter();
    Boolean isEmpty();
}
