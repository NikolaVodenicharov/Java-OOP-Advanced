package models.reactors;

public class CryoReactor extends ReactorImpl{
    private int cryoProductionIndex;

    protected CryoReactor(int id, int moduleCapacity, int cryoProductionIndex) {
        super(id, moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = super.getTotalEnergyOutput() * this.cryoProductionIndex;

        if (this.isReactorOverheat(energyOutput, this.getTotalHeatAbsorbing())){
            return 0;
        }

        return 0;
    }
}
