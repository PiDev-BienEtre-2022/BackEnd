package tn.esprit.happyemployee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.happyemployee.entities.Departement;
import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.repositories.DepartementRepository;
import tn.esprit.happyemployee.repositories.EquipeRepository;

@Service
public class EquipeService implements IEquipeService {

	@Autowired
	EquipeRepository equipeRepository;
	@Autowired
	DepartementRepository departementRepository;
	
	@Override
	public Long addEquipe(Equipe equipe) {
		equipeRepository.save(equipe);
		return equipe.getId();
	}

	@Override
	public Long modifierEquipe(Equipe equipe) {
		equipeRepository.save(equipe);
		return equipe.getId();
	}

	@Override
	public void supprimerEquipe(Long equipeId) {
		equipeRepository.deleteById(equipeId);
	}

	@Override
	public List<Equipe> getEquipes() {
		return equipeRepository.findAll();
	}

	@Override
	public Equipe getEquipeById(Long equipeId) {
		return equipeRepository.findById(equipeId).get();
	}

	@Override
	public void affecterEquipeADepartement(Long equipeId, Long departementId) {
		Departement departement = departementRepository.findById(departementId).get();
		Equipe equipe = equipeRepository.findById(equipeId).get();		
		if(departement != null && equipe != null ) {
			equipe.setDepartement(departement);
			equipeRepository.save(equipe);
		}
	}

}
