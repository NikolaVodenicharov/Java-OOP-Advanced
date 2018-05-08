package factories;

import models.emergencyCenters.EmergencyCenter;

import java.lang.reflect.Constructor;

public class EmergencyCenterFactoryImpl implements EmergencyCenterFactory {
    @Override
    public EmergencyCenter create(String fullTypeName, String name, String emergencyLeft) {
        EmergencyCenter center = null;

        try {
            Class clazz = Class.forName(fullTypeName);
            Constructor constructor = clazz.getDeclaredConstructor(String.class, Integer.class);

            center = (EmergencyCenter) constructor.newInstance(name, Integer.valueOf(emergencyLeft));

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return center;
    }
}
