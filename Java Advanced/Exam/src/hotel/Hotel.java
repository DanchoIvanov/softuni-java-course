package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if (roster.size() < capacity){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        Person personToRemove = getPerson(name);
        if (personToRemove != null){
            roster.remove(personToRemove);
            return true;
        }
        return false;
    }

    private Person getPerson(String name){
        for (Person person : roster) {
            if (person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public Person getPerson(String name, String hometown){
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)){
                return person;
            }
        }
        return null;
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.name));
        this.roster.forEach(p -> sb.append(p).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void setRoster(List<Person> roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
