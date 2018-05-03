package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data){
        this.data = data;
    }

    protected String[] getData(){
        return data;
    }
}
