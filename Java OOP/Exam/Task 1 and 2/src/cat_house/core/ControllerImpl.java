package cat_house.core;

import cat_house.common.ConstantMessages;
import cat_house.common.ExceptionMessages;
import cat_house.entities.cat.Cat;
import cat_house.entities.cat.LonghairCat;
import cat_house.entities.cat.ShorthairCat;
import cat_house.entities.houses.House;
import cat_house.entities.houses.LongHouse;
import cat_house.entities.houses.ShortHouse;
import cat_house.entities.toys.Ball;
import cat_house.entities.toys.Mouse;
import cat_house.entities.toys.Toy;
import cat_house.repositories.ToyRepository;
import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller {

    private ToyRepository toys = new ToyRepository();
    private Map<String, House> houses = new LinkedHashMap<>();

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("LongHouse")){
            house = new LongHouse(name);
        } else if (type.equals("ShortHouse")){
            house = new ShortHouse(name);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        this.houses.put(name, house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")){
            toy = new Ball();
        } else if (type.equals("Mouse")){
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException (ExceptionMessages.INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = houses.get(houseName);
        Toy toy = this.toys.findFirst(toyType);
        if (toy == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        house.buyToy(toy);
        this.toys.removeToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        if (catType.equals("ShorthairCat")){
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")){
            cat =  new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException (ExceptionMessages.INVALID_CAT_TYPE);
        }

        House house = this.houses.get(houseName);
        String output;
        if (house.getClass().getSimpleName().equals("LongHouse") && cat.getClass().getSimpleName().equals("ShorthairCat")
                || house.getClass().getSimpleName().equals("ShortHouse") && cat.getClass().getSimpleName().equals("LonghairCat")){
            output = ConstantMessages.UNSUITABLE_HOUSE;
        } else {
            house.addCat(cat);
            output = String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName );
        }

        return output;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.get(houseName);
        int fedCatsCount = house.getCats().size();
        house.feeding();
        return String.format(ConstantMessages.FEEDING_CAT, fedCatsCount);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.get(houseName);
        double catsTotalPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toysTotalPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double totalPrice = catsTotalPrice + toysTotalPrice;
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, totalPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : this.houses.values()){
            sb.append(house.getStatistics()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
