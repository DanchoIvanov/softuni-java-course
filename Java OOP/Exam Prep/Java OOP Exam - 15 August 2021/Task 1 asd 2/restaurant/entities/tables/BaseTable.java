package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    private void setSize(int size){
        if (size < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople){
        if (numberOfPeople <=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public void setReservedTable(boolean reservedTable) {
        isReservedTable = reservedTable;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        this.allPeople = numberOfPeople * pricePerPerson;
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setReservedTable(true);
        setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double foodPrice = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beveragesPrice = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();
        return foodPrice + beveragesPrice;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        setReservedTable(false);
    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table - ").append(getTableNumber()).append(System.lineSeparator())
                .append("Size - ").append(getSize()).append(System.lineSeparator())
                .append("Type - ").append(getClass().getSimpleName()).append(System.lineSeparator())
                .append("All price - ").append(pricePerPerson());

        return sb.toString();
    }

    public BaseTable(int number, int size, double pricePerPerson) {
        this.setNumber(number);
        this.setSize(size);
        this.setPricePerPerson(pricePerPerson);
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();

    }
}
