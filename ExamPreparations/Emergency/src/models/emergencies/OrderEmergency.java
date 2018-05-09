package models.emergencies;

import enums.EmergencyLevel;
import enums.Status;
import utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency {

    private Status status;

    public OrderEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            String status) {
        super(description, emergencyLevel, registrationTime);
        this.setStatus(status);
    }

    @Override
    public int specificInfo() {
        return status.getValue();
    }

    private void setStatus(String status){
        String converted = status.toUpperCase();
        if (converted.contains("-")){
            converted = converted.replace("-", "_");
        }

        this.status = Status.valueOf(converted);
    }
}
