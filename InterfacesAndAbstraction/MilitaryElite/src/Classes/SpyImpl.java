package Classes;

import Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();
        formatted
                .append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Code Number: %s", this.codeNumber));

        return formatted.toString();
    }
}
