package Models;

import Abstracts.Inhabitant;

public class Robot implements Inhabitant {
    private String model;
    private String id;

    public Robot(String model, String id){
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
