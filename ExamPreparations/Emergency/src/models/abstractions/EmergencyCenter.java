package models.abstractions;

import java.util.Collection;

public interface EmergencyCenter {
    String getName();
    Integer getEmergencyLeft();
    Collection<Emergency> getEmergencies();
    void addEmergency(Emergency emergency);
    boolean isForRetirement();
}
