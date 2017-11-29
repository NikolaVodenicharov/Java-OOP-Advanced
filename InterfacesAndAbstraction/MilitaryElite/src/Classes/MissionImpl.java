package Classes;

import Interfaces.Mission;

public class MissionImpl implements Mission {
    private String name;
    private String state;

    public MissionImpl(String name, String state){
        this.name = name;
        this.state = state;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();
        formatted
                .append(String.format(
                        "Code Name: %s State: %s",
                        this.name,
                        this.state));

        return formatted.toString();
    }
}
