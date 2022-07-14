package tn.esprit.happyemployee.entities;

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

    @ManyToMany
    @JoinTable(
            name = "participation",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "training",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Feedback> feedbacks;

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
