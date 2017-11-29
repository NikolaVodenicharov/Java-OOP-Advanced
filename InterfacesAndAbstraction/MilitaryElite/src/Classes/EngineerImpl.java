package Classes;

import Interfaces.Engineer;
import Interfaces.Repair;

import java.util.Collection;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;

    public EngineerImpl(
            String id,
            String firstName,
            String lastName,
            double salary,
            String corp,
            Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = repairs;
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();
        formatted
                .append(super.toString())
                .append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());

        for (Repair repair : repairs) {
            formatted
                    .append("  ")
                    .append(repair)
                    .append(System.lineSeparator());
        }

        return formatted.toString().trim();
    }
}
