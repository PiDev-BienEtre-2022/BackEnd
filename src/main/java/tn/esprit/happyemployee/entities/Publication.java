package tn.esprit.happyemployee.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.happyemployee.domain.enums.Reaction;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPub;
	private String contenu;
	@Temporal(TemporalType.DATE)
	private Date datePub;
	@Enumerated(EnumType.STRING) // lezemni nes2el 3liha
	private Reaction reaction;
	
	@JsonIgnore
	@OneToMany(mappedBy = "publication")
	private Set<Commentaire> commentaires;
	
	@ManyToOne
    @JoinColumn(name="idTheme", nullable=false)
    private Theme theme;

	
	

}
 