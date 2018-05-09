package models.centers;

public interface EmergencyCenter {
    String getName();
    boolean isForRetirement();
    void processEmergency();
}
