package tn.esprit.happyemployee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedback")
@EntityListeners(AuditingEntityListener.class)
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int note;

    private String comment;

    @JoinColumn(name="ID_user",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    @JoinColumn(name="ID_training",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Training training;

    @Override
    public String toString() {
        return "feedback{" +
                "id=" + id +
                ", note=" + note +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                '}';
    }
}
