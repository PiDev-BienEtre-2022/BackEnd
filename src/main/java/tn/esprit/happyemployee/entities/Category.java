package tn.esprit.happyemployee.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tn.esprit.happyemployee.domain.enums.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
@EntityListeners(AuditingEntityListener.class)
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Nom;
    private float percentage;

    private Boolean status;


    @Enumerated(EnumType.STRING)
    private Domain domain;

   @JsonIgnore
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Goal> goals;

    @JsonIgnore
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Training> trainings;


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", percentage=" + percentage +
                ", domain=" + domain +
                '}';
    }
}
