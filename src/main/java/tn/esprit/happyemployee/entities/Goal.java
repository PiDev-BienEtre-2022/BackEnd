package tn.esprit.happyemployee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goal")
@EntityListeners(AuditingEntityListener.class)
public class Goal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Titre;
    private String description;
    private float percentage;
    private Boolean validate;
    private Boolean status;

    @JoinColumn(name="ID_Category",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;

    @JoinColumn(name="ID_Evaluation",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Evaluation evaluation;


    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", Titre='" + Titre + '\'' +
                ", description='" + description + '\'' +
                ", percentage=" + percentage +
                ", validate=" + validate +
                '}';
    }

}
