package tn.esprit.happyemployee.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "events", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "id"
    })
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date beginDate;
    private Date endDate;
    private Integer maxPlaces;
    private String address;
    private Float cost;
    private Date createdAt;
    private Date updatedAt; 
}