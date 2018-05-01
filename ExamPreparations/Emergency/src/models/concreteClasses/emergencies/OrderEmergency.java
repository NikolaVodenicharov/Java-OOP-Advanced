package models.concreteClasses.emergencies;

import models.abstractions.Emergency;
import models.enums.EmergencyLevel;
import models.enums.OrderEmergencyStatus;
import models.concreteClasses.RegistrationTime;

public class OrderEmergency extends Emergency {

    private OrderEmergencyStatus status;

    public OrderEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            OrderEmergencyStatus status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }
}
