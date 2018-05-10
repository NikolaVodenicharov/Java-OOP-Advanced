package tests;

import org.junit.Assert;
import org.junit.Test;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

public class RegistrationTimeImplTests {
    private static final String NOT_PARSED_TIME = "12:24 25/02/2016";

    @Test
    public void getMinutes() {
        RegistrationTime time = new RegistrationTimeImpl(NOT_PARSED_TIME);

        Assert.assertEquals(24, (int) time.getMinutes());
    }

    @Test
    public void getHour() {
        RegistrationTime time = new RegistrationTimeImpl(NOT_PARSED_TIME);

        Assert.assertEquals(12, (int) time.getHour());
    }

    @Test
    public void getDay() {
        RegistrationTime time = new RegistrationTimeImpl(NOT_PARSED_TIME);

        Assert.assertEquals(25, (int) time.getDay());
    }

    @Test
    public void getMonth() {
        RegistrationTime time = new RegistrationTimeImpl(NOT_PARSED_TIME);

        Assert.assertEquals(2, (int) time.getMonth());
    }

    @Test
    public void getYear() {
        RegistrationTime time = new RegistrationTimeImpl(NOT_PARSED_TIME);

        Assert.assertEquals(2016, (int) time.getYear());
    }

    @Test
    public void toStringTest() {
        RegistrationTime time = new RegistrationTimeImpl(NOT_PARSED_TIME);

        Assert.assertEquals(NOT_PARSED_TIME, time.toString());
    }
}