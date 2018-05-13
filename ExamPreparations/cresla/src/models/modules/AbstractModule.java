package models.modules;

public abstract class AbstractModule implements Module {
    private int id;
    private int additionalParameter;

    protected AbstractModule(int id, int additionalParameter){
        this.id = id;
        this.additionalParameter = additionalParameter;
    }

    @Override
    public int getId() {
        return this.id;
    }

    protected int getAdditionalParameter(){
        return this.additionalParameter;
    }
}
