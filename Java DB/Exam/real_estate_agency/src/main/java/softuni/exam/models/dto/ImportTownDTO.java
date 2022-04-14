package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ImportTownDTO {

    @NotNull
    @Size(min = 2)
    private String townName;

    @Positive
    private int population;

    @NotNull
    public String getTownName() {
        return townName;
    }

    public int getPopulation() {
        return population;
    }
}
