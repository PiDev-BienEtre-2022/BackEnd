package tn.esprit.happyemployee.Model;

import javax.persistence.*;

@Entity
@Table(name="goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String Titre;
    private String description;
    private float percentage;
    private int validate;

    /*@JoinColumn(name="ID_Category",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;

    @JoinColumn(name="ID_Evaluation",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Evaluation evaluation;

    public Goal() {
        this.category = new Category();
        this.evaluation = new Evaluation();
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getValidate() {
        return validate;
    }

    public void setValidate(int validate) {
        this.validate = validate;
    }
}
