package Models;

import Abstracts.Birthable;

public class Pet implements Birthable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }
    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}
