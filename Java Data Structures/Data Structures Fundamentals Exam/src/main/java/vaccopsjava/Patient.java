package vaccopsjava;

import java.util.Objects;

public class Patient {

    public String name;
    public int height;
    public int age;
    public String town;

    public Patient(String name, int height, int age, String town) {
        this.name = name;
        this.height = height;
        this.age = age;
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
