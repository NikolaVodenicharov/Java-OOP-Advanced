package models.abstractions;

import java.util.Collection;
import java.util.Collections;

public abstract class  EmergencyCenterImpl implements EmergencyCenter {
    private Collection<Emergency> emergencies;
    private String name;
    private Integer emergencyLeft;

    public EmergencyCenterImpl(String name, Integer emergencyLeft, Collection<Emergency> emergencies) {
        setName(name);
        setEmergencyLeft(emergencyLeft);
        this.emergencies = emergencies;
    }

    @Override
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getEmergencyLeft() {
        return emergencyLeft;
    }
    private void setEmergencyLeft(Integer emergencyLeft) {
        this.emergencyLeft = emergencyLeft;
    }

    @Override
    public Collection<Emergency> getEmergencies(){
        return Collections.unmodifiableCollection(emergencies);
    }

    @Override
    public void addEmergency(Emergency emergency){
        emergencies.add(emergency);
    }

    @Override
    public boolean isForRetirement(){
        boolean isRetirementTime = emergencyLeft == 0;

        return isRetirementTime;
    }
}
