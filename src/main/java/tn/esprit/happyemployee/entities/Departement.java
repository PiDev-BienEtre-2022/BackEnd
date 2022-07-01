package tn.esprit.happyemployee.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "departement")
@EntityListeners(AuditingEntityListener.class)

public class Departement  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
    private String nom;

    @ManyToOne
    FilterTeletravail filtre;
    
	@OneToMany(mappedBy="departement")
	private Set<Equipe> equipes;
	

	@Override
	public String toString() {
		return "Departement [Id=" + Id + ", nom=" + nom + ", filtre=" + filtre + ", equipes=" + equipes + "]";
	}

	public Departement(String nom, FilterTeletravail filtre) {
		super();
		this.nom = nom;
		this.filtre = filtre;
	}

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

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}
}
