package models.abstractions;

public abstract class EmergencyCenterImpl implements EmergencyCenter {

    private String name;
    private Integer emergencyLeft;

    public EmergencyCenterImpl(String name, Integer emergencyLeft) {
        setName(name);
        setEmergencyLeft(emergencyLeft);
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
    public boolean isForRetirement(){
        boolean isRetirementTime = emergencyLeft == 0;

        return isRetirementTime;
    }
}
