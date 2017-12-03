public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    @Override
    public String toString(){
        return this.toTitleCase(this.name());
    }

    private String toTitleCase(String word){
        StringBuilder titleCase = new StringBuilder();

        Character firstChar = word.charAt(0);
        Character upperCase = Character.toUpperCase(firstChar);
        titleCase.append(upperCase);

        for (int i = 1; i < word.length(); i++) {
            Character nextChar = word.charAt(i);
            Character lowerCase = Character.toLowerCase(nextChar);
            titleCase.append(lowerCase);
        }

        return titleCase.toString();
    }
}
