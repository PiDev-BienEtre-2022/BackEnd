package tn.esprit.happyemployee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.happyemployee.domain.enums.*;

@Getter
@Setter
@Entity
@Table(name = "demandetele")
@EntityListeners(AuditingEntityListener.class)

public class DemandeTeleTravail implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	private Date dateDemande;
	
	private String noteEmp;
	
	private String noteManager;
	
	@Enumerated(EnumType.STRING)
	private DemandeUrgency urgency;

	private Boolean extra;
	
	@Enumerated(EnumType.STRING)
	private DemandeApprove systemApprove;
	
	@Enumerated(EnumType.STRING)
	private DemandeApprove managerApprove;
	
	@Enumerated(EnumType.STRING)
	private DemandeReason reason;
	
	@ManyToOne
	//@JsonIgnore
	User user;

	public DemandeTeleTravail() {}
	
	public DemandeTeleTravail(Date dateCreation, Date dateDemande, String noteEmp, String noteManager,
			DemandeUrgency urgency, Boolean extra, DemandeApprove systemApprove, DemandeApprove managerApprove,
			DemandeReason reason) {
		super();
		this.dateCreation = dateCreation;
		this.dateDemande = dateDemande;
		this.noteEmp = noteEmp;
		this.noteManager = noteManager;
		this.urgency = urgency;
		this.extra = extra;
		this.systemApprove = systemApprove;
		this.managerApprove = managerApprove;
		this.reason = reason;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public String getNoteEmp() {
		return noteEmp;
	}

	public void setNoteEmp(String noteEmp) {
		this.noteEmp = noteEmp;
	}

	public String getNoteManager() {
		return noteManager;
	}

	public void setNoteManager(String noteManager) {
		this.noteManager = noteManager;
	}

	public DemandeUrgency getUrgency() {
		return urgency;
	}

	public void setUrgency(DemandeUrgency urgency) {
		this.urgency = urgency;
	}

	public Boolean getExtra() {
		return extra;
	}

	public void setExtra(Boolean extra) {
		this.extra = extra;
	}

	public DemandeApprove getSystemApprove() {
		return systemApprove;
	}

	public void setSystemApprove(DemandeApprove systemApprove) {
		this.systemApprove = systemApprove;
	}

	public DemandeApprove getManagerApprove() {
		return managerApprove;
	}

	public void setManagerApprove(DemandeApprove managerApprove) {
		this.managerApprove = managerApprove;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DemandeReason getReason() {
		return reason;
	}
	
	public void setReason(DemandeReason reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "DemandeTeleTravail [Id=" + Id + ", dateCreation=" + dateCreation + ", dateDemande=" + dateDemande
				+ ", noteEmp=" + noteEmp + ", noteManager=" + noteManager + ", urgency=" + urgency + ", extra=" + extra
				+ ", systemApprove=" + systemApprove + ", managerApprove=" + managerApprove + ", reason=" + reason
				+ "]";
	}


}
