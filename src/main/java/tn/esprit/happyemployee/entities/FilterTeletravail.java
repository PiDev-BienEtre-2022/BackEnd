package tn.esprit.happyemployee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@NoArgsConstructor
@Entity
@Table(name = "filterTeletravail")
@EntityListeners(AuditingEntityListener.class)


public class FilterTeletravail  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id ;

    private String nom;
    
    /****** Start:  For who *******/
    @JsonIgnore
	@OneToMany(mappedBy="filtre")
	private Set<Equipe> equipes;
	
    @JsonIgnore
	@OneToMany(mappedBy="filtre")
	private Set<Departement> departements;
	
	/****** End: For who *******/
	
	/****** Start: Accept Cond *******/
	
	/* Equipe filter: nbr employe teletravail */
	@Enumerated(EnumType.STRING)
	private FilterPeriode eqPeriode;
	
	@Enumerated(EnumType.STRING)
	private FilterTyp eqFilterType;
	
	private long eqMetrique;
	
	/* Employee filter : nbr day teletravail */
	@Enumerated(EnumType.STRING)
	private FilterPeriode epPeriode;
	
	@Enumerated(EnumType.STRING)
	private FilterTyp epFilterType;

	private long epMetrique;

	
	/****** End: Accept Conds *******/
	
	
	/****** Start: Commit Cond *******/
	
	@Enumerated(EnumType.STRING)
	private FilterCommit commitLogic;
	
	/****** End: Commit Cond *******/
	
	
	/****** Start: when run filter *******/
	
	@Enumerated(EnumType.STRING)
	private RunSchedule runSchedule;
	
	private String runAt;
	
	@Temporal(TemporalType.DATE)
	private Date lastRun;
	
	@Temporal(TemporalType.DATE)
	private Date nextRun;
	
	@Enumerated(EnumType.STRING)
	private SortLogic sortLogic;
	/****** End: when run filter *******/
	
	public FilterTeletravail(){}


	public FilterTeletravail(long id, String nom, Set<Equipe> equipes, Set<Departement> departements,
			FilterPeriode eqPeriode, FilterTyp eqFilterType, long eqMetrique, FilterPeriode epPeriode,
			FilterTyp epFilterType, long epMetrique, FilterCommit commitLogic, RunSchedule runSchedule, String runAt,
			Date lastRun, Date nextRun, SortLogic sortLogic) {
		super();
		Id = id;
		this.nom = nom;
		this.equipes = equipes;
		this.departements = departements;
		this.eqPeriode = eqPeriode;
		this.eqFilterType = eqFilterType;
		this.eqMetrique = eqMetrique;
		this.epPeriode = epPeriode;
		this.epFilterType = epFilterType;
		this.epMetrique = epMetrique;
		this.commitLogic = commitLogic;
		this.runSchedule = runSchedule;
		this.runAt = runAt;
		this.lastRun = lastRun;
		this.nextRun = nextRun;
		this.sortLogic = sortLogic;
	}





	@Override
	public String toString() {
		return "FilterTeletravail [Id=" + Id + ", nom=" + nom + ", equipes=" + equipes + ", departements="
				+ departements + ", eqPeriode=" + eqPeriode + ", eqFilterType=" + eqFilterType + ", eqMetrique="
				+ eqMetrique + ", epPeriode=" + epPeriode + ", epFilterType=" + epFilterType + ", epMetrique="
				+ epMetrique + ", commitLogic=" + commitLogic + ", runSchedule=" + runSchedule + ", runAt=" + runAt
				+ ", lastRun=" + lastRun + ", nextRun=" + nextRun + ", sortLogic=" + sortLogic + "]";
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

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Set<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}

	public FilterPeriode getEqPeriode() {
		return eqPeriode;
	}

	public void setEqPeriode(FilterPeriode eqPeriode) {
		this.eqPeriode = eqPeriode;
	}

	public FilterTyp getEqFilterType() {
		return eqFilterType;
	}

	public void setEqFilterType(FilterTyp eqFilterType) {
		this.eqFilterType = eqFilterType;
	}

	public long getEqMetrique() {
		return eqMetrique;
	}

	public void setEqMetrique(long eqMetrique) {
		this.eqMetrique = eqMetrique;
	}

	public FilterPeriode getEpPeriode() {
		return epPeriode;
	}

	public void setEpPeriode(FilterPeriode epPeriode) {
		this.epPeriode = epPeriode;
	}


	public long getEpMetrique() {
		return epMetrique;
	}

	public void setEpMetrique(long epMetrique) {
		this.epMetrique = epMetrique;
	}

	public FilterCommit getCommitLogic() {
		return commitLogic;
	}

	public FilterTyp getEpFilterType() {
		return epFilterType;
	}


	public void setEpFilterType(FilterTyp epFilterType) {
		this.epFilterType = epFilterType;
	}


	public void setCommitLogic(FilterCommit commitLogic) {
		this.commitLogic = commitLogic;
	}

	public RunSchedule getRunSchedule() {
		return runSchedule;
	}

	public void setRunSchedule(RunSchedule runSchedule) {
		this.runSchedule = runSchedule;
	}

	public String getRunAt() {
		return runAt;
	}

	public void setRunAt(String runAt) {
		this.runAt = runAt;
	}

	public Date getLastRun() {
		return lastRun;
	}

	public void setLastRun(Date lastRun) {
		this.lastRun = lastRun;
	}

	public Date getNextRun() {
		return nextRun;
	}

	public void setNextRun(Date nextRun) {
		this.nextRun = nextRun;
	}

	public SortLogic getSortLogic() {
		return sortLogic;
	}

	public void setSortLogic(SortLogic sortLogic) {
		this.sortLogic = sortLogic;
	}
	
	
	
	
	
	
	
}
