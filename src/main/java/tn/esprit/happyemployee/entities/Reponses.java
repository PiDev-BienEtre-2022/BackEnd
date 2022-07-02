package tn.esprit.happyemployee.entities;

import javax.persistence.*;

@Entity
@Table(name="reponses")
public class Reponses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Nom;
}
