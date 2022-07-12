package tn.esprit.happyemployee.entities;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Nom;
    // key etrangé question

    //list des questions

    //maybe levelquiz set here
}
