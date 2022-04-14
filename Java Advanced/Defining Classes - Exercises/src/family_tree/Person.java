package family_tree;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {

    private static int count = 1;
    private int position;
    private String firstName;
    private String lastName;
    private String date;
    private Set<Person> parents;
    private Set<Person> children;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
        this.position = count++;
    }

    public int getPosition() {
        return position;
    }

    public Person(String date) {
        this.date = date;
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
        this.position = count++;
    }

    public Person(String firstName, String lastName, String date){
        this(firstName, lastName);
        this.date = date;
    }

    public void setParents(Set<Person> parents) {
        this.parents = parents;
    }

    public void setChildren(Set<Person> children) {
        this.children = children;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDate() {
        return date;
    }

    public Set<Person> getParents() {
        return parents;
    }

    public Set<Person> getChildren() {
        return children;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s",this.getFirstName(), this.getLastName(), this.getDate());
    }
}
