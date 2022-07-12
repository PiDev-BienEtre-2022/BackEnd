package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.repositories.*;

import java.util.List;

@Service
public class ReponsesService implements IReponsesService {

	@Autowired
	ReponsesRepository equipeRepository;
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	UserRepository userRepository;
	/*
	@Override
	public void supprimerEquipe(Long equipeId) {
		equipeRepository.deleteById(equipeId);
	}
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

	@Override
	public void affecterUserAEquipe(Long userId, Long equipeId) {
		User user = userRepository.findById(userId).get();
		Equipe equipe = equipeRepository.findById(equipeId).get();
		if(user != null && equipe != null) {
			user.setEquipe(equipe);
			userRepository.save(user);
		}
	}
*/
}
