package models.concreteClasses.emergencyCenters;

import models.abstractions.Emergency;
import models.abstractions.EmergencyCenterImpl;

import java.util.Collection;

public class FireCenter extends EmergencyCenterImpl {

    public FireCenter(String name, Integer emergencyLeft, Collection<Emergency> emergencies) {
        super(name, emergencyLeft, emergencies);
    }
}
