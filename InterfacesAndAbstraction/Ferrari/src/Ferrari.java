public class Ferrari implements Car {
    private final String DEFAULT_MODEL = "488-Spider";

    private String model;
    private String driverName;

    public Ferrari(String driverName) {
        this.model = DEFAULT_MODEL;
        this.driverName = driverName;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public String getDriverName() {
        return null;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString(){
        return String.format(
                "%s/%s/%s/%s",
                this.model,
                this.useBrakes(),
                this.pushGasPedal(),
                this.driverName);
    }
}
