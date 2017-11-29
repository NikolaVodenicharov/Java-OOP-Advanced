package Classes;

import Interfaces.Commando;
import Interfaces.Mission;
import javafx.scene.web.HTMLEditorSkin;

import java.util.Collection;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando{
    private Collection<Mission> missions;

    public CommandoImpl(
            String id,
            String firstName,
            String lastName,
            double salary,
            String corp,
            Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corp);
        this.missions = missions;
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public void completeMission() {

    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();
        formatted
                .append(super.toString())
                .append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());

        for (Mission mission : missions) {
            formatted
                    .append("  ")
                    .append(mission)
                    .append(System.lineSeparator());
        }

        return formatted.toString().trim();
    }
}
