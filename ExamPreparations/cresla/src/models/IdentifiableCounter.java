package models;

public final class IdentifiableCounter {
    private static int counter = 1;

    public static int getCount(){
        return counter++;
    }
}
