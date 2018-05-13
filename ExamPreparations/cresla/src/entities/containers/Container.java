package entities.containers;

import models.modules.AbsorbingModule;
import models.modules.EnergyModule;

public interface Container {

    long getTotalEnergyOutput();

    long getTotalHeatAbsorbing();

    void addEnergyModule(EnergyModule energyModule);

    void addAbsorbingModule(AbsorbingModule absorbingModule);
}
