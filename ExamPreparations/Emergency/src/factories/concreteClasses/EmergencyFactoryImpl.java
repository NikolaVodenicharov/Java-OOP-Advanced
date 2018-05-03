package factories.concreteClasses;

import factories.abstractions.EmergencyFactory;
import models.abstractions.Emergency;
import models.concreteClasses.RegistrationTime;
import models.enums.EmergencyLevel;

import java.lang.reflect.Constructor;

public class EmergencyFactoryImpl implements EmergencyFactory {

    public Emergency create(
            String fullTypeName,
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime){

        Emergency emergency = null;

        try {
            Class clazz = Class.forName(fullTypeName);
            Constructor constructor = clazz.getDeclaredConstructor(String.class, EmergencyLevel.class, RegistrationTime.class);
            emergency = (Emergency) constructor.newInstance(description, emergencyLevel, registrationTime);

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return emergency;
    }
}
