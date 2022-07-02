package tn.esprit.happyemployee.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCom;
	private String text;
	@Temporal(TemporalType.DATE)
	private Date dateCom;
	
	@ManyToOne
    @JoinColumn(name="idPub", nullable=false)// lezemni nes2el 3liha
	private Publication publication;
	
	
	
	
}
