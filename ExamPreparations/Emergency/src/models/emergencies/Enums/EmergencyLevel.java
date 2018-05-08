package models.emergencies.Enums;

public enum EmergencyLevel {
    MINOR,
    MAJOR,
    DISASTER;

    @Override
    public String toString(){
        String lowerCaseName = this.name().toLowerCase();
        String titleCaseName = lowerCaseName.replace(this.name().substring(0,1), lowerCaseName.substring(0,1));

        return titleCaseName;
    }
}
