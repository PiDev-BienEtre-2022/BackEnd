package tn.esprit.happyemployee.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String date;
    private float score;
    private String note;

    /*@JsonBackReference
    @OneToMany(mappedBy = "Goal",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Goal> goals;

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }*/

    public Evaluation() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
