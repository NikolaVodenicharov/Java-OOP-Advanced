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
            String registrationTime,
            String specialInfo){

        Emergency emergency = null;

        try {
            Class clazz = Class.forName(fullTypeName);
            Constructor constructor =
                    clazz.getDeclaredConstructor(
                            String.class,
                            EmergencyLevel.class,
                            RegistrationTime.class,
                            String.class);

            EmergencyLevel level = EmergencyLevel.valueOf(emergencyLevel.toUpperCase());
            RegistrationTime time = new RegistrationTimeImpl(registrationTime);

            emergency = (Emergency) constructor.newInstance(description, level, time, specialInfo);

        }
        catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return emergency;
    }
}
