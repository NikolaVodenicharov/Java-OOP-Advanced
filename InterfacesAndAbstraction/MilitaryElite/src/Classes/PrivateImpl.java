package Classes;

import Interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();
        formatted
                .append(super.toString())
                .append(String.format(" Salary: %.2f", this.salary));

        return formatted.toString();
    }
}
