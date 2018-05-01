package models.abstractions;

public abstract class EmergencyCenter {

    private String name;
    private Integer emergenciesLimitBeforeRetire;

    protected EmergencyCenter(String name, Integer emergenciesLimitBeforeRetire) {
        this.setName(name);
        this.setEmergenciesLimitBeforeRetire(emergenciesLimitBeforeRetire);
    }

    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }

    public Integer getEmergenciesLimitBeforeRetire() {
        return emergenciesLimitBeforeRetire;
    }
    private void setEmergenciesLimitBeforeRetire(Integer emergenciesLimitBeforeRetire) {
        this.emergenciesLimitBeforeRetire = emergenciesLimitBeforeRetire;
    }

    public abstract Boolean isForRetirement();
}
