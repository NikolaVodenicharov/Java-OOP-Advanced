package enums;

public enum EmergencyLevel {
    MINOR,
    MAJOR,
    DISASTER;

    @Override
    public String toString(){
        String lowerCaseName = this.name().toLowerCase();
        String titleCaseName = lowerCaseName.replace(lowerCaseName.substring(0,1), this.name().substring(0,1));

        return titleCaseName;
    }
}
