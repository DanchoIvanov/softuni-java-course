package glacial_expedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        if (super.getEnergy() < 7){
            super.setEnergy(0);
        } else {
            this.setEnergy(this.getEnergy() - 7);
        }
    }
}
