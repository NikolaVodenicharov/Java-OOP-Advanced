package models.concreteClasses.emergencyCenters;

import models.abstractions.Emergency;
import models.abstractions.EmergencyCenterImpl;

import java.util.Collection;

public class PoliceCenter extends EmergencyCenterImpl {

    public PoliceCenter(String name, Integer emergencyLeft, Collection<Emergency> emergencies) {
        super(name, emergencyLeft, emergencies);
    }
}
