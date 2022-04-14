package cat_house.entities.houses;

import cat_house.common.ConstantMessages;
import cat_house.common.ExceptionMessages;
import cat_house.entities.cat.Cat;
import cat_house.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (cats.size() >= this.capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:",this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        if (this.cats.isEmpty()){
            sb.append("Cats: none")
                    .append(System.lineSeparator());
        } else {
            List<String> catNames = this.cats.stream().map(Cat::getName).collect(Collectors.toList());
            sb.append(String.format("Cats: %s", String.join(" ", catNames)))
                    .append(System.lineSeparator());
        }
        sb.append(String.format("Toys: %d Softness: %d", this.toys.size(), this.sumSoftness()));

        return sb.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }
}