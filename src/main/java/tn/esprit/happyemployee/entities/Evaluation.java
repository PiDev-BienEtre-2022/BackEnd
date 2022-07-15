package tn.esprit.happyemployee.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_goals;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_eval;

    private int nb_goals_domain;
    private int nb_goals_other;
    private float min_per_domain;

    private float score;
    private String comment;
    private int validated;
    private int finalValidate;
    private Boolean status;

    @JsonIgnore
    @OneToMany(mappedBy = "evaluation",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Goal> goals;

    @JoinColumn(name="ID_user",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", dateGoals=" + date_goals +
                ", dateEval=" + date_eval +
                ", nbGoalsDomain=" + nb_goals_domain +
                ", nbGoalsOther=" + nb_goals_other +
                ", minPerDomain=" + min_per_domain +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                ", goals=" + goals +
                '}';
    }
}
