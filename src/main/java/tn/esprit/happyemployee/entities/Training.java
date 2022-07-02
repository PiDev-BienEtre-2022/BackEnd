package tn.esprit.happyemployee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "training")
@EntityListeners(AuditingEntityListener.class)
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String label;
    private Date date;
    private int nbParticipant;
    private String place;

    private Boolean status;

    @JoinColumn(name="ID_Category",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", date=" + date +
                ", nbParticipant=" + nbParticipant +
                ", place='" + place + '\'' +
                '}';
    }



}
