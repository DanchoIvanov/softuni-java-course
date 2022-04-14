package _04;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Lob()
    @Column(length = 2000, columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Diagnose diagnose;

    @ManyToMany
    @JoinTable(
            name = "visitations_medicaments",
            joinColumns =
            @JoinColumn(name = "visitation_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "medicament_id", referencedColumnName = "id")
    )
    private Set<Medicament> medicaments;

    public Visitation() {}

    public Visitation(LocalDateTime date, String comments) {
        this.date = date;
        this.comments = comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
