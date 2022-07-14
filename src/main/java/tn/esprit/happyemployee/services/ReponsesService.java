package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.entities.Reponses;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.repositories.*;

import java.util.List;

@Service
public class ReponsesService implements IReponsesService {

	@Autowired
	ReponsesRepository reponsesRepository;
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void supprimerReponse(Long idReponses) {
		reponsesRepository.deleteById(idReponses);
	}
	@Override
	public Long addReponses(Reponses reponse) {
		reponsesRepository.save(reponse);
		return reponse.getIdReponses();
	}

	@Override
	public List<Reponses> getReponses() {
		return reponsesRepository.findAll();
	}

	@Override
	public Reponses getReponsesById(Long idReponses) {
		return reponsesRepository.findById(idReponses).get();
	}

	@Override
	public void affecterEquipeADepartement(Long idReponses, Long idQuiz) {
		Quiz quiz = quizRepository.findById(idQuiz).get();
		Reponses reponse = reponsesRepository.findById(idReponses).get();
		if(quiz != null && reponse != null ) {
			reponse.setQuiz(quiz);
			reponsesRepository.save(reponse);
		}
	}
/*
	@Override
	public void affecterUserAEquipe(Long userId, Long idReponses) {
		User user = userRepository.findById(userId).get();
		Reponses reponse = reponsesRepository.findById(idReponses).get();
		if(user != null && reponse != null) {
			user.setReponses(reponse);
			userRepository.save(user);
		}
	}*/

}
