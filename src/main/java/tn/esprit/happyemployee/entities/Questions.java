package tn.esprit.happyemployee.entities;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String questions;

}
