package models.reactors;

public class CryoReactor extends ReactorImpl{
    private int cryoProductionIndex;

    protected CryoReactor(int cryoProductionIndex, int moduleCapacity) {
        super(moduleCapacity);
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
