package tn.esprit.happyemployee.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Nom;
    private float percentage;

    /*@JsonBackReference
    @OneToMany(mappedBy = "Goal",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Goal> goals;

    @JsonBackReference
    @OneToMany(mappedBy = "Training",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Training> trainings;

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }*/

    public Category() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

 }
