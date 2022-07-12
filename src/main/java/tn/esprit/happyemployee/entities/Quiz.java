package tn.esprit.happyemployee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idQuiz;
    @NotBlank
    private String Nom;
    @OneToMany(mappedBy = "quiz")
    private Set<Questions> questions;
    @OneToMany(mappedBy = "quiz")
    private Set<Reponses> reponses;

    //clé employé?

    //maybe levelquiz set here
}
