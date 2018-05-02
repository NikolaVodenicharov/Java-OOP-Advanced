package models.concreteClasses.emergencyCenters;

import models.abstractions.Emergency;
import models.abstractions.EmergencyCenter;
import models.concreteClasses.emergencies.OrderEmergency;

import java.util.Collection;
import java.util.Collections;

public class PoliceCenter extends EmergencyCenter {

    private Collection<OrderEmergency> emergencies;

    public PoliceCenter(String name, Integer emergencyLeft, Collection<OrderEmergency> emergencies) {
        super(name, emergencyLeft);

        this.emergencies = emergencies;
    }

    @Override
    public Collection<? extends Emergency> getEmergencies() {
        return Collections.unmodifiableCollection(emergencies);
    }
}