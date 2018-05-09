package models.centers;

public abstract class BaseEmergencyCenter implements EmergencyCenter {
    private String name;
    private Integer processEmergencyLeft;

    protected BaseEmergencyCenter(String name, Integer processEmergencyLeft) {
        setName(name);
        setProcessEmergencyLeft(processEmergencyLeft);
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void processEmergency(){
        if (isForRetirement()){
            throw new IllegalStateException("Center is for retirement");
        }

        processEmergencyLeft--;
    }
    @Override
    public boolean isForRetirement(){
        return processEmergencyLeft <= 0;
    }

    private void setName(String name) {
        if (name.length() < 3){
            throw new IllegalArgumentException("Name length must be at least 3 symbols.");
        }

        this.name = name;
    }
    private void setProcessEmergencyLeft(Integer processEmergencyLeft) {
        if (processEmergencyLeft < 0){
            throw new IllegalArgumentException("Process emergency left can not be negative number.");
        }
        this.processEmergencyLeft = processEmergencyLeft;
    }
}
