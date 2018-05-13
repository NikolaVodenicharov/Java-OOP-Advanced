package models.modules;

public class CooldownSystem extends AbstractModule implements AbsorbingModule{
    public CooldownSystem(int id, int additionalParameter) {
        super(id, additionalParameter);
    }

    @Override
    public int getHeatAbsorbing() {
        return super.getAdditionalParameter();
    }
}
