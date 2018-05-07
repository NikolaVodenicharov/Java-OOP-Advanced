package models.emergencies.Utils;

public interface RegistrationTime {
    Integer getMinutes();
    Integer getHour();
    Integer getDay();
    Integer getMonth();
    Integer getYear();
    String toString();
}
