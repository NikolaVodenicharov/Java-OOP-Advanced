package models.concreteClasses.emergencyCenters;

import models.abstractions.EmergencyCenterImpl;
import models.concreteClasses.emergencies.PropertyEmergency;

import java.util.*;

public class FireCenter extends EmergencyCenterImpl {

    private Collection<PropertyEmergency> emergencies;

    public FireCenter(String name, Integer emergencyLeft, Collection<PropertyEmergency> emergencies) {
        super(name, emergencyLeft);

        this.emergencies = emergencies;
    }

    @Override
    public Collection<PropertyEmergency> getEmergencies() {
        return Collections.unmodifiableCollection(emergencies);
    }
}
