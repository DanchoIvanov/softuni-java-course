package glacial_expedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {

    private static final double ENERGY = 40;

    public GlacierExplorer(String name) {
        super(name, ENERGY);
    }
}
