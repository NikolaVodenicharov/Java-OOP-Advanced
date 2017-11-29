package Classes;

import Interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier{
    private String corp;

    protected SpecialisedSoldierImpl(String id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.corp = corp;
    }

    @Override
    public String getCorp() {
        return this.corp;
    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();
        formatted
                .append(super.toString())
                .append(System.lineSeparator())
                .append(String.format(
                        "Corps: %s",
                        this.corp));

        return formatted.toString();
    }
}
