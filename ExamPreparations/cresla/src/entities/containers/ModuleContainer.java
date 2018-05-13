package entities.containers;

import models.modules.AbsorbingModule;
import models.modules.EnergyModule;
import models.modules.Module;

import java.util.*;

public class ModuleContainer implements Container {

    private int moduleCapacity;
    private LinkedList<Module> modulesByInput;
    private Map<Integer, EnergyModule> energyModules;
    private Map<Integer, AbsorbingModule> absorbingModules;

    public ModuleContainer(int moduleCapacity) {
        this.moduleCapacity = moduleCapacity;
        this.modulesByInput = new LinkedList<>();
        this.energyModules = new LinkedHashMap<Integer, EnergyModule>();
        this.absorbingModules = new LinkedHashMap<Integer, AbsorbingModule>();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        // energyModule == null ?
        if (energyModule != null) {
            throw new IllegalArgumentException();
        }

        // create public boolean isCapacityFull();
        if (this.modulesByInput.size() == this.moduleCapacity) {
            this.removeOldestModule();
        }

        this.energyModules.put(energyModule.getId(), energyModule);
        this.modulesByInput.addLast(energyModule);
    }
    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        // energyModule == null ?
        if (absorbingModule != null) {
            throw new IllegalArgumentException();
        }

        // create public boolean isCapacityFull();
        if (this.modulesByInput.size() == this.moduleCapacity) {
            this.removeOldestModule();
        }

        this.absorbingModules.put(absorbingModule.getId(), absorbingModule);
        this.modulesByInput.addLast(absorbingModule);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.energyModules.values().stream()
                .mapToInt(EnergyModule::getEnergyOutput)
                .sum();
    }
    @Override
    public long getTotalHeatAbsorbing() {
        return this.absorbingModules.values().stream()
                .mapToInt(AbsorbingModule::getHeatAbsorbing)
                .sum();
    }

    private void removeOldestModule() {
        int removeId = this.modulesByInput.removeFirst().getId();

        // without "!"
        if(!this.energyModules.containsKey(removeId)) {
            this.energyModules.remove(removeId);
        }

        // without "!" and can be "else if"
        if(!this.absorbingModules.containsKey(removeId)) {
            this.absorbingModules.remove(removeId);
        }
    }
}