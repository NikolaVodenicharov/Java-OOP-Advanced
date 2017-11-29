package Classes;

import Interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked){
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString(){
        StringBuilder formatted = new StringBuilder();
        formatted
                .append(String.format(
                        "Part Name: %s Hours Worked: %d",
                        this.partName,
                        this.hoursWorked));

        return formatted.toString();
    }
}
