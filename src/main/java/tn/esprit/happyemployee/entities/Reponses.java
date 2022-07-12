package tn.esprit.happyemployee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="reponses")
public class Reponses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idReponses;

    private String Nom;
    @NotBlank
    private Date QuizDate;
    //clé employé içi à declarer

    //scoore pour chaque reponse, et on affiche en front le score du theme ou d'employé
    @NotBlank
    private float scoore;

    @ManyToOne
    @JoinColumn(name="idQuiz", nullable=false)
    private Quiz quiz;



}
