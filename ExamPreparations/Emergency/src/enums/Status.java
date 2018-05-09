package enums;

public enum Status {
    SPECIAL(1),
    NON_SPECIAL(0);

    private int value;

    Status(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
