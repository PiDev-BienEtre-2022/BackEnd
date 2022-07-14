package tn.esprit.happyemployee.services;

import java.util.List;

import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.Departement;
import tn.esprit.happyemployee.entities.Equipe;

public interface IDepartementService {

	Long addDepartement(Departement departement);

	Long modifierDepartement(Departement departement);

	void supprimerDepartement(Long departementId);
	
	List<Departement> getDepartements();
	
	Departement getDepartementById(Long departementId);
}
