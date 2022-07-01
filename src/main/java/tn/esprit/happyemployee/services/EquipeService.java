package tn.esprit.happyemployee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.repositories.EquipeRepository;

@Service
public class EquipeService implements IEquipeService {

	@Autowired
	EquipeRepository equipeRepository;
	
	@Override
	public Long addEquipe(Equipe equipe) {
		equipeRepository.save(equipe);
		return equipe.getId();
	}

	@Override
	public Long modifierCours(Equipe equipe) {
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

}
