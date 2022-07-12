package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.repositories.QuizRepository;
import tn.esprit.happyemployee.repositories.UserRepository;

@Service
public class QuizService implements IQuizService{

	@Autowired
	QuizRepository quizRepository;
	@Autowired
	UserRepository userRepository;

/*
	@Override

	public Long addDepartement(Departement departement) {
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
*/

}
