package data.concreteClasses;

import data.abstractions.EmergencyCenterRegister;
import models.abstractions.EmergencyCenter;

import java.util.ArrayDeque;

public class EmergencyCenterRegisterImpl implements EmergencyCenterRegister {
    private ArrayDeque<EmergencyCenter> centers;

    public EmergencyCenterRegisterImpl(ArrayDeque<EmergencyCenter> centers){
        this.centers = centers;
    }

    @Override
    public void enqueueEmergency(EmergencyCenter center) {
        centers.add(center);
    }

    @Override
    public EmergencyCenter dequeueEmergency() {
        return centers.remove();
    }

    @Override
    public EmergencyCenter peekEmergency() {
        return centers.peek();
    }

    @Override
    public Boolean isEmpty() {
        return centers.isEmpty();
    }
}
