package space_station.models.planets;

import space_station.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class PlanetImpl implements Planet {

    private String name;
    private Collection<String> items;

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name){
        if (name.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public PlanetImpl(String name) {
        this.setName(name);
        this.items = new ArrayList<>();
    }
}
