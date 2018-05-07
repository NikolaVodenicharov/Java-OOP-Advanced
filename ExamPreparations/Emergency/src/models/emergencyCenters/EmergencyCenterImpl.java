package models.emergencyCenters;

public abstract class  EmergencyCenterImpl implements EmergencyCenter {
    private String name;
    private Integer emergencyLeft;

    protected EmergencyCenterImpl(String name, Integer emergencyLeft) {
        setName(name);
        setEmergencyLeft(emergencyLeft);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public boolean isForRetirement(){
        return emergencyLeft <= 0;
    }

    private void setName(String name) {
        if (name.length() < 3){
            throw new IllegalArgumentException("Name length must be at least 3 symbols.");
        }

        this.name = name;
    }
    private void setEmergencyLeft(Integer emergencyLeft) {
        if (emergencyLeft < 0){
            throw new IllegalArgumentException("Emergency left can not be negative number.");
        }
        this.emergencyLeft = emergencyLeft;
    }
}
