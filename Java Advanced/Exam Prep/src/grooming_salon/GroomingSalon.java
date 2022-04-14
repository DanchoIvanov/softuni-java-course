package grooming_salon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (data.size() < capacity){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        Pet petToRemove = getPet(name);
        if (petToRemove !=null){
            this.data.remove(petToRemove);
            return true;
        }
        return false;
    }

    private Pet getPet(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)){
                return pet;
            }
        }
        return null;
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        data.forEach(p -> sb.append(p.getName()).append(" ").append(p.getOwner()).append(System.lineSeparator()));
        return ("The grooming salon has the following clients:" + System.lineSeparator() + sb.toString().trim());

    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
