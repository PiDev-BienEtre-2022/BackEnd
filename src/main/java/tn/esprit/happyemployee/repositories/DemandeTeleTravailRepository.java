package tn.esprit.happyemployee.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.entities.FilterTeletravail;
import tn.esprit.happyemployee.entities.User;

public interface DemandeTeleTravailRepository extends JpaRepository<DemandeTeleTravail, Long> {

	@Query("SELECT f FROM DemandeTeleTravail f where f.user=:user")
	public List<DemandeTeleTravail> getDemandesByUser(@Param("user") User user);
	
	@Query("SELECT count(f) FROM DemandeTeleTravail f where f.user.equipe =:equipe"
			+ " and dateDemande <=:endDate and dateDemande>=:startDate  and managerApprove = 'approved' ")
	public Long getDemndeCountPerEquipe(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("equipe") Equipe equipe);

	@Query("SELECT count(f) FROM DemandeTeleTravail f where f.user =:user"
			+ " and dateDemande <=:endDate and dateDemande>=:startDate  and managerApprove = 'approved' ")
	public Long getDemndeCountPerEmployee(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("user") User user);
	
	
	@Query("SELECT f FROM DemandeTeleTravail f where f.user.equipe.filtre =:filter "
			+ "or f.user.equipe.departement.filtre =:filter "
			+ " and  systemApprove = 'waiting' ")
	public List<DemandeTeleTravail> getDemandeByFilter(@Param("filter") FilterTeletravail filter);
}
