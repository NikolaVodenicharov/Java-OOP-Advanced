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
    public void enqueueCenter(EmergencyCenter center) {
        centers.add(center);
    }

    @Override
    public EmergencyCenter dequeueCenter() {
        return centers.remove();
    }

    @Override
    public EmergencyCenter peekCenter() {
        return centers.peek();
    }

    @Override
    public int size() {
        return centers.size();
    }
}
