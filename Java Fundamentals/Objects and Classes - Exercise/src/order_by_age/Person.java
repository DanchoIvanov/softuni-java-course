package order_by_age;

public class Person {

    private String name;
    private String ID;
    private int age;


    public Person(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;

    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.",this.name, this.ID, this.age);
    }
}
