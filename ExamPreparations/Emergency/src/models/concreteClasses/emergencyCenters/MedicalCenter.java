package models.concreteClasses.emergencyCenters;

import models.abstractions.Emergency;
import models.abstractions.EmergencyCenter;
import models.concreteClasses.emergencies.HealthEmergency;

import java.util.Collection;
import java.util.Collections;

public class MedicalCenter extends EmergencyCenter {

    private Collection<HealthEmergency> emergencies;

    public MedicalCenter(String name, Integer emergencyLeft, Collection<HealthEmergency> emergencies) {
        super(name, emergencyLeft);

        this.emergencies = emergencies;
    }

    @Override
    public Collection<? extends Emergency> getEmergencies() {
        return Collections.unmodifiableCollection(emergencies);
    }
}
