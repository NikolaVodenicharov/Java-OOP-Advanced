package models.modules;

public class HeatProcessor extends AbstractModule implements AbsorbingModule{
    protected HeatProcessor(int id, int additionalParameter) {
        super(id, additionalParameter);
    }

    @Override
    public int getHeatAbsorbing() {
        return super.getAdditionalParameter();
    }
}
