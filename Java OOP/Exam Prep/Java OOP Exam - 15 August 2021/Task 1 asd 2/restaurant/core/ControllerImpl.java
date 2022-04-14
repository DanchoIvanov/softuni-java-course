package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.BeverageRepositoryImpl;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepositoryImpl;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepositoryImpl, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepositoryImpl = beverageRepositoryImpl;
        this.tableRepository = tableRepository;
        this.totalIncome = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        Food food;
        if (type.equals("Salad")){
            food = new Salad(name, price);
        } else {
            food = new VeganBiscuits(name, price);
        }
        if (healthFoodRepository.foodByName(name) != null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
        }
        healthFoodRepository.add(food);
        return (String.format(OutputMessages.FOOD_ADDED, name));
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        Beverages beverage;
        if (type.equals("Fresh")){
            beverage = new Fresh(name, counter, brand);
        } else {
            beverage = new Smoothie(name, counter, brand);
        }
        if (beverageRepositoryImpl.beverageByName(name, brand) != null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
        }
        beverageRepositoryImpl.add(beverage);
        return String.format(OutputMessages.BEVERAGE_ADDED, beverage.getClass().getSimpleName(), brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table;
        if (type.equals("Indoors")){
            table = new Indoors(tableNumber, capacity);
        } else {
            table = new InGarden(tableNumber, capacity);
        }
        if (tableRepository.byNumber(tableNumber) != null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
        }
        tableRepository.add(table);
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = null;
        for (Table currentTable : tableRepository.getAllEntities()){
            if (!currentTable.isReservedTable() && currentTable.getSize() >= numberOfPeople){
                table = currentTable;
                break;
            }
        }
        String output;
        if (table == null){
           return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE,numberOfPeople);
        } else {
            table.reserve(numberOfPeople);
            return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
        }

    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);
        if (table == null){
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        if (food == null){
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }
        table.orderHealthy(food);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        Beverages beverage = beverageRepositoryImpl.beverageByName(name, brand);
        if (table == null){
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        if (beverage == null){
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name ,brand);
        }
        table.orderBeverages(beverage);
        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        if (table == null){
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        double bill = table.bill() + table.allPeople();
        totalIncome += bill;
        table.clear();
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(OutputMessages.TOTAL_MONEY, totalIncome);
    }
}
