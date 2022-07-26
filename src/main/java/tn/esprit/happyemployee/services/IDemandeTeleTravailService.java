package tn.esprit.happyemployee.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.entities.FilterTeletravail;
import tn.esprit.happyemployee.entities.User;


public interface IDemandeTeleTravailService {

	Long addDemandeTeleTravail(DemandeTeleTravail demande,Long userId);

	Long modifierDemandeTeleTravail(DemandeTeleTravail demande);

	void supprimerDemandeTeleTravail(Long demandeId);
	
	List<DemandeTeleTravail> getDemandeTeleTravails();
	
	DemandeTeleTravail getDemandeTeleTravailById(Long demandeId);

	List<DemandeTeleTravail> getDemandebyUser(Long userId);
	
	FilterTeletravail getFilterbyDemande(DemandeTeleTravail demande);
	
	DemandeTeleTravail processSystemLogic(DemandeTeleTravail demande, FilterTeletravail filter);
	
	Long getDemndeCountPerEmployee(Date startDate , Date endDate, User user);
	
	Long getDemndeCountPerEquipe(Date startDate , Date endDate, Equipe equipe);
	
	boolean isDemandeAccepted(DemandeTeleTravail demande, FilterTeletravail filter);
	
	List<DemandeTeleTravail> getDemandeTeleTravailsByEquipeId(Long equipeID);

}
