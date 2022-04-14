package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

public class BeverageRepositoryImpl extends Data<Beverages> implements BeverageRepository<Beverages> {

    @Override
    public Beverages beverageByName(String name, String brand){
        for (Beverages currentBeverage : this.getAllEntities()){
            if (currentBeverage.getName().equals(name) && currentBeverage.getBrand().equals(brand)){
                return currentBeverage;
            }
        }
        return null;
    }
}
