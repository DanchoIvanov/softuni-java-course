package glacial_expedition.models.explorers;

import glacial_expedition.common.ExceptionMessages;
import glacial_expedition.models.suitcases.Carton;
import glacial_expedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {

    private String name;
    private double energy;
    private Suitcase suitcase;

    public void search(){
        if (this.energy < 15){
            this.setEnergy(0);
        } else {
            this.setEnergy(this.energy - 15);
        }
    }

    public boolean canSearch(){
        return this.energy > 0;
    }


    private void setName(String name) {
        if (name == null || name.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0){
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }
}
