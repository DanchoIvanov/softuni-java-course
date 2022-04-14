package restaurant.repositories;

import restaurant.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Data<T> implements Repository<T> {

    private Collection<T> entities;

    public Data() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<T> getAllEntities() {
        return Collections.unmodifiableCollection(entities);
    }

    @Override
    public void add(T entity) {
        entities.add(entity);
    }
}
