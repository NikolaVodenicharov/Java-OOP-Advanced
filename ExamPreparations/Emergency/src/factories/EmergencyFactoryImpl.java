package factories;

import models.emergencies.Emergency;
import models.emergencies.Utils.RegistrationTime;
import models.emergencies.Enums.EmergencyLevel;
import models.emergencies.Utils.RegistrationTimeImpl;

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
            Constructor constructor = clazz.getDeclaredConstructor(String.class, EmergencyLevel.class, RegistrationTimeImpl.class);
            emergency = (Emergency) constructor.newInstance(description, emergencyLevel, registrationTime);

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return emergency;
    }
}
