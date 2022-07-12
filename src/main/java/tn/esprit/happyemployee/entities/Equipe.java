package tn.esprit.happyemployee.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "equipe")
@EntityListeners(AuditingEntityListener.class)

public class Equipe  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
    private String nom;
	
    @ManyToOne
    FilterTeletravail filtre;
    
    @ManyToOne
    Departement departement;
    
    @OneToMany(mappedBy="equipe")
	private Set<User> users;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public FilterTeletravail getFiltre() {
		return filtre;
	}

	public void setFiltre(FilterTeletravail filtre) {
		this.filtre = filtre;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Equipe(){}
	
	public Equipe(String nom, FilterTeletravail filtre) {
		super();
		this.nom = nom;
		this.filtre = filtre;
	}

	@Override
	public String toString() {
		return "Equipe [Id=" + Id + ", nom=" + nom + ", filtre=" + filtre + "]";
	}
   
	
}
