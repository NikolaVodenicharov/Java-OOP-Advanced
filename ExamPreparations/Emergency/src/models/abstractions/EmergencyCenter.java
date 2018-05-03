package models.abstractions;

import java.util.Collection;

public interface EmergencyCenter {
    String getName();
    Integer getEmergencyLeft();
    Collection<? extends Emergency> getEmergencies();
    boolean isForRetirement();
}
