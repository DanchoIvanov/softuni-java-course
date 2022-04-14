package cat_house.repositories;

import cat_house.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository {

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    private Collection<Toy> toys;

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return this.toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        for (Toy toy : this.toys){
            if (toy.getClass().getSimpleName().equals(type)){
                return toy;
            }
        }
        return null;
    }
}
