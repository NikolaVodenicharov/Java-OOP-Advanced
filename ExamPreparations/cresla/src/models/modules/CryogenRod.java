package models.modules;

public class CryogenRod extends AbstractModule implements EnergyModule{
    public CryogenRod(int id, int additionalParameter) {
        super(id, additionalParameter);
    }

    @Override
    public int getEnergyOutput() {
        return super.getAdditionalParameter();
    }
}
