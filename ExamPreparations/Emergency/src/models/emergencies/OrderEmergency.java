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
            OrderEmergencyStatus status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public int specificInfo() {
        return status.getValue();
    }
}
