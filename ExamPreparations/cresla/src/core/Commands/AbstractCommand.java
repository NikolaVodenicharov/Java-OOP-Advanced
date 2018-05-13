package core.Commands;

import core.Manager;

public abstract class AbstractCommand implements Executable {
    private Manager manager;

    protected AbstractCommand(Manager manager){
        this.manager = manager;
    }
}
