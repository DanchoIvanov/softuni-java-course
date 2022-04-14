package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

public class HealthFoodRepositoryImpl extends Data<HealthyFood> implements HealthFoodRepository<HealthyFood> {

    @Override
    public HealthyFood foodByName(String name){
        for (HealthyFood currentFood : this.getAllEntities()){
            if (currentFood.getName().equals(name)){
                return currentFood;
            }
        }
        return null;
    }
}
