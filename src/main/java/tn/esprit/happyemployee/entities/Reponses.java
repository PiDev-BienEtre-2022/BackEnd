package tn.esprit.happyemployee.entities;

import javax.persistence.*;
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
    private long id;
    private String Nom;
    private Date QuizDate;
    //clé employé içi à declarer

    //clé Quiz içi à declarer

    //scoore pour chaque reponse, et on affiche en front le score du theme ou d'employé
    private float scoore;

}
