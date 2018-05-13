package core;

import models.reactors.Reactor;
import models.reactors.ReactorFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private Map<Integer, Reactor> reactors;
    private ReactorFactory reactorFactory;
    private static int idForIdentifiable = 0;

    public ManagerImpl(HashMap<Integer, Reactor> reactors, ReactorFactory reactorFactory) {
        this.reactors = reactors;
        this.reactorFactory = reactorFactory;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String reactorSimpleName = arguments.get(0);
        int additionalParameter = Integer.valueOf(arguments.get(1));
        int moduleCapacity = Integer.valueOf(arguments.get(2));

        Reactor reactor = this.reactorFactory.create(idForIdentifiable++, reactorSimpleName, additionalParameter, moduleCapacity);
        this.reactors.put(reactor.getId(), reactor);

        return String.format(
                "Created %s Reactor – %d",
                reactorSimpleName,
                reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.valueOf(arguments.get(0));
        String moduleSimpleName = arguments.get(1);
        int additionalParameter = Integer.valueOf(arguments.get(2));



        return String.format(
                "%s- {moduleId} to Reactor - {reactorId}",
                moduleSimpleName);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        return null;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return null;
    }
}
