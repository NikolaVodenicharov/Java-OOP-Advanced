package Classes;

import Interfaces.LeutenantGeneral;
import Interfaces.Private;

import java.util.Collection;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral{
    private Collection<Private> privates;

    public LeutenantGeneralImpl(String id, String firstName, String lastName, double salary, Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();
        formatted
                .append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());
        for (Private p : privates) {
            formatted
                    .append("  ")
                    .append(p)
                    .append(System.lineSeparator());
        }

        return formatted.toString().trim();
    }
}
