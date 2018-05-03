package data.abstractions;

import models.abstractions.Emergency;

public interface EmergencyRegister {
    void enqueueEmergency(Emergency emergency);
    Emergency dequeueEmergency();
    Emergency peekEmergency();
    Boolean isEmpty();
}
