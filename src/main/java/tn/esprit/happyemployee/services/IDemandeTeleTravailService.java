package tn.esprit.happyemployee.services;

import java.util.List;

import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.FilterTeletravail;

public interface IDemandeTeleTravailService {

	Long getDemandeTeleTravail(DemandeTeleTravail demande);

	Long modifierDepartement(DemandeTeleTravail demande);

	void supprimerDemandeTeleTravail(Long demandeId);
	
	List<DemandeTeleTravail> getDemandeTeleTravails();
	
	DemandeTeleTravail getDemandeTeleTravailById(Long demandeId);
}
