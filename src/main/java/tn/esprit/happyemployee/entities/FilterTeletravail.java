package tn.esprit.happyemployee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
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

import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
	@OneToMany(mappedBy="filtre")
	private Set<Equipe> equipes;
	
	@OneToMany(mappedBy="filtre")
	private Set<Departement> departements;
	
	/****** End: For who *******/
	
	/****** Start: Accept Cond *******/
	
	/* Equipe filter: nbr employe teletravail */
	@Enumerated(EnumType.STRING)
	private FilterPeriode eqPeriode;
	
	@Enumerated(EnumType.STRING)
	private FilterType eqFilterType;
	
	private long eqMetrique;
	
	/* Employee filter : nbr day teletravail */
	@Enumerated(EnumType.STRING)
	private FilterPeriode epPeriode;
	
	@Enumerated(EnumType.STRING)
	private FilterType epFilterType;

	private long epMetrique;
	
	private String urgFilter; 
	
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


	@Override
	public String toString() {
		return "FilterTeletravail [Id=" + Id + ", nom=" + nom + ", eqPeriode=" + eqPeriode + ", eqFilterType="
				+ eqFilterType + ", eqMetrique=" + eqMetrique + ", epPeriode=" + epPeriode + ", epFilterType="
				+ epFilterType + ", epMetrique=" + epMetrique + ", urgFilter=" + urgFilter + ", commitLogic="
				+ commitLogic + ", runSchedule=" + runSchedule + ", runAt=" + runAt + ", lastRun=" + lastRun
				+ ", nextRun=" + nextRun + ", sortLogic=" + sortLogic + "]";
	}

	
	public FilterTeletravail(String nom, FilterPeriode eqPeriode, FilterType eqFilterType, long eqMetrique,
			FilterPeriode epPeriode, FilterType epFilterType, long epMetrique, String urgFilter,
			FilterCommit commitLogic, RunSchedule runSchedule, String runAt, Date lastRun, Date nextRun,
			SortLogic sortLogic) {
		super();
		this.nom = nom;
		this.eqPeriode = eqPeriode;
		this.eqFilterType = eqFilterType;
		this.eqMetrique = eqMetrique;
		this.epPeriode = epPeriode;
		this.epFilterType = epFilterType;
		this.epMetrique = epMetrique;
		this.urgFilter = urgFilter;
		this.commitLogic = commitLogic;
		this.runSchedule = runSchedule;
		this.runAt = runAt;
		this.lastRun = lastRun;
		this.nextRun = nextRun;
		this.sortLogic = sortLogic;
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

	public FilterType getEqFilterType() {
		return eqFilterType;
	}

	public void setEqFilterType(FilterType eqFilterType) {
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

	public FilterType getEpFilterType() {
		return epFilterType;
	}

	public void setEpFilterType(FilterType epFilterType) {
		this.epFilterType = epFilterType;
	}

	public long getEpMetrique() {
		return epMetrique;
	}

	public void setEpMetrique(long epMetrique) {
		this.epMetrique = epMetrique;
	}

	public String getUrgFilter() {
		return urgFilter;
	}

	public void setUrgFilter(String urgFilter) {
		this.urgFilter = urgFilter;
	}

	public FilterCommit getCommitLogic() {
		return commitLogic;
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
