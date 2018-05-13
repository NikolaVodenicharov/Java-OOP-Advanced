package models.reactors;

import entities.containers.Container;
import entities.containers.ModuleContainer;
import models.modules.AbsorbingModule;
import models.modules.EnergyModule;

public abstract class ReactorImpl implements Reactor{
    private Container container;
    private int id;
    private int moduleCount = 0;

    protected ReactorImpl(int id, int moduleCapacity){
        this.id = id;
        this.container = new ModuleContainer(moduleCapacity);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }
    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return this.moduleCount;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
        this.moduleCount++;
    }
    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
        this.moduleCount++;
    }

    @Override
    public int getId() {
        return this.id;
    }

    protected boolean isReactorOverheat(long energyOutput, long heatAbsorbing){
        return energyOutput > heatAbsorbing;
    }
}
