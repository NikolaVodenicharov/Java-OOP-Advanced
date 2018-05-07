package models.emergencies.Enums;

public enum OrderEmergencyStatus {
    SPECIAL(1),
    NOT_SPECIAL(0);

    private int value;

    OrderEmergencyStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
