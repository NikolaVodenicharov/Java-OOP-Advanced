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
            String emergencyLevel,
            String registrationTime){

        Emergency emergency = null;

        try {
            Class clazz = Class.forName(fullTypeName);
            Constructor constructor =
                    clazz.getDeclaredConstructor(
                            String.class,
                            EmergencyLevel.class,
                            RegistrationTimeImpl.class);

            EmergencyLevel level = EmergencyLevel.valueOf(emergencyLevel.toUpperCase());
            RegistrationTime time = new RegistrationTimeImpl(registrationTime);

            emergency = (Emergency) constructor.newInstance(description, level, time);

        }
        catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return emergency;
    }
}
