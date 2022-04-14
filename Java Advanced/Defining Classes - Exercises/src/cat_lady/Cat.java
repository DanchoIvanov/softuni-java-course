package cat_lady;

public class Cat {

    private String breed;
    private String name;
    private double specificCharacteristics;

    public Cat(String breed, String name, double specificCharacteristics) {
        this.breed = breed;
        this.name = name;
        this.specificCharacteristics = specificCharacteristics;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public double getSpecificCharacteristics() {
        return specificCharacteristics;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.breed, this.name, this.specificCharacteristics);
    }
}
