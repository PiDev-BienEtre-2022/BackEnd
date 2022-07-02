package tn.esprit.happyemployee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evaluation")
@EntityListeners(AuditingEntityListener.class)
public class Evaluation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;
    private float score;
    private String note;
    private Boolean status;

    @JsonBackReference
    @OneToMany(mappedBy = "evaluation",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Goal> goals;

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", date=" + date +
                ", score=" + score +
                ", note='" + note + '\'' +
                '}';
    }

}
