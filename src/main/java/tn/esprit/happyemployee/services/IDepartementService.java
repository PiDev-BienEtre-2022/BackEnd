package tn.esprit.happyemployee.services;

import java.util.List;

import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.Departement;

public interface IDepartementService {

	Long getDepartement(Departement departement);

	Long modifierDepartement(Departement departement);

	void supprimerDepartement(Long departementId);
	
	List<Departement> getDepartements();
	
	Departement getDepartementById(Long departementId);
}
