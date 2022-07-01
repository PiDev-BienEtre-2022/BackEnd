package tn.esprit.happyemployee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.happyemployee.entities.Departement;
import tn.esprit.happyemployee.repositories.DepartementRepository;

@Service
public class DepartementService implements IDepartementService {

	@Autowired
	DepartementRepository departementRepository;
	
	@Override
	public Long getDepartement(Departement departement) {
		departementRepository.save(departement);
		return departement.getId();
	}

	@Override
	public Long modifierDepartement(Departement departement) {
		departementRepository.save(departement);
		return departement.getId();
	}

	@Override
	public void supprimerDepartement(Long departementId) {
		departementRepository.deleteById(departementId);
	}

	@Override
	public List<Departement> getDepartements() {
		return departementRepository.findAll();
	}

	@Override
	public Departement getDepartementById(Long departementId) {
		return departementRepository.findById(departementId).get();
	}

}
