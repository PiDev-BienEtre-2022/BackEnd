package tn.esprit.happyemployee.Model;

import javax.persistence.*;

@Entity
@Table(name="training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String label;
    private String date;
    private int nbParticipant;
    private String place;

    /*@JoinColumn(name="ID_Category",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;

    public Training() {
        this.category = new Category();
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNbParticipant() {
        return nbParticipant;
    }

    public void setNbParticipant(int nbParticipant) {
        this.nbParticipant = nbParticipant;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
