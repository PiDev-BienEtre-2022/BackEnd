package tn.esprit.happyemployee.entities;

import javax.persistence.*;

@Entity
@Table(name="quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Nom;

}
