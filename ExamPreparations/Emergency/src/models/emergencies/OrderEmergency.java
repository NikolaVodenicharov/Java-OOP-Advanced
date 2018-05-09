package models.emergencies;

import models.emergencies.Enums.EmergencyLevel;
import models.emergencies.Enums.OrderEmergencyStatus;
import models.emergencies.Utils.RegistrationTime;

public class OrderEmergency extends EmergencyImpl {

    private OrderEmergencyStatus status;

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

        this.status = OrderEmergencyStatus.valueOf(status.toUpperCase());
    }
}
