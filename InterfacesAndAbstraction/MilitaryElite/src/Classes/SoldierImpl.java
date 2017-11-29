package Classes;

import Interfaces.Soldier;

public abstract class SoldierImpl implements Soldier {
    private String id;
    private String firstName;
    private String lastName;

    protected SoldierImpl(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId(){
        return this.id;
    }

    @Override
    public String getFirstName(){
        return this.firstName;
    }

    @Override
    public String getLastName(){
        return this.lastName;
    }

    @Override
    public String toString(){
        String formatted =
                String.format(
                        "Name: %s %s Id: %s",
                        this.firstName,
                        this.lastName,
                        this.id);

        return formatted;
    }
}
