package vaccopsjava;

import java.util.Objects;

public class Doctor {

    public String name;
    public int popularity;

    public Doctor(String name, int popularity) {
        this.name = name;
        this.popularity = popularity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(name, doctor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
