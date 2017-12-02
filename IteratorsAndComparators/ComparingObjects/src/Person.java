public class Person implements Comparable<Person>{
    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        int result = 0;

        if (!this.name.equals(other.name)){
            result = this.name.compareTo(other.name);
        }
        else if(this.age != other.age){
            result = this.age - other.age;
        }
        else{
            result = this.town.compareTo(other.town);
        }

        return result;
    }
}
