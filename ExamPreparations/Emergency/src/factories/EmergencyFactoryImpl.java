package factories;

import models.emergencies.Emergency;
import utils.RegistrationTime;
import enums.EmergencyLevel;
import utils.RegistrationTimeImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return emergency;
    }
}
