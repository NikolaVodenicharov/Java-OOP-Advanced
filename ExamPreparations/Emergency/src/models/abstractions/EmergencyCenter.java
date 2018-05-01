package models.abstractions;

import java.util.Collection;

public abstract class  EmergencyCenter {

    private String name;
    private Integer emergencyLeft;

    public EmergencyCenter(String name, Integer emergencyLeft) {
        setName(name);
        setEmergencyLeft(emergencyLeft);
    }

    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }

    public Integer getEmergencyLeft() {
        return emergencyLeft;
    }
    private void setEmergencyLeft(Integer emergencyLeft) {
        this.emergencyLeft = emergencyLeft;
    }

    public abstract Collection<? extends Emergency> getEmergencies();

    public boolean isForRetirement(){
        boolean isRetirementTime = emergencyLeft == 0;

        return isRetirementTime;
    }
}
