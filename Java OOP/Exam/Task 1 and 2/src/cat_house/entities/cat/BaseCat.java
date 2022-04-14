package cat_house.entities.cat;

import cat_house.common.ExceptionMessages;

public abstract class BaseCat implements Cat {

    private String name;
    private String breed;
    private int kilograms;
    private double price;


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.breed = breed;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price){
        if (price <= 0){
            throw new IllegalArgumentException(ExceptionMessages.CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    protected BaseCat(String name, String breed, double price) {
        this.setName(name);
        this.setBreed(breed);
        this.setPrice(price);
    }

    protected void setKilograms(int kilograms){
        this.kilograms = kilograms;
    }

    @Override
    public abstract void eating();
}
