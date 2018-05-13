package models.reactors;

public class HeatReactor extends ReactorImpl{
    private int heatReductionIndex;

    public HeatReactor(int heatReductionIndex, int moduleCapacity) {
        super(moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = super.getTotalEnergyOutput();

        if (this.isReactorOverheat(energyOutput, this.getTotalHeatAbsorbing())){
            return 0;
        }

        return 0;
    }
    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + this.heatReductionIndex;
    }
}
