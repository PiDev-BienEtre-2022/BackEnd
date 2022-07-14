package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.Departement;
import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.entities.Questions;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.repositories.QuestionsRepository;
import tn.esprit.happyemployee.repositories.QuizRepository;

import java.util.List;

@Service
public class QuestionsService implements IQuestionsService {

	@Autowired
	QuestionsRepository questionsRepository;
	@Autowired
	QuizRepository quizRepository;

	@Override
	public Long addQuestions(Questions question) {
		questionsRepository.save(question);
		return question.getId();
	}

	@Override
	public Long modifyQuestions(Questions question) {
		questionsRepository.save(question);
		return question.getId();
	}

	@Override
	public void supprimerQuestions(Long idQuestion) {
		questionsRepository.deleteById(idQuestion);
	}

	@Override
	public List<Questions> getQuestions() {
		return questionsRepository.findAll();
	}

	@Override
	public Questions getQuestionById(Long idQuestion) {
		return questionsRepository.findById(idQuestion).get();
	}

	@Override
	public void setQuestionsToQuiz(Long idQuestion, Long idQuiz) {
		Quiz quiz = quizRepository.findById(idQuiz).get();
		Questions questions = questionsRepository.findById(idQuestion).get();
		if(quiz != null && questions != null ) {
			questions.setQuiz(quiz);
			questionsRepository.save(questions);
		}
	}

}
