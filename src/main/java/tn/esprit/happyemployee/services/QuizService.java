package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.Questions;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.repositories.QuestionsRepository;
import tn.esprit.happyemployee.repositories.QuizRepository;
import tn.esprit.happyemployee.repositories.UserRepository;

import java.util.List;

@Service
public class QuizService implements IQuizService{

	@Autowired
	QuizRepository quizRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	QuestionsRepository questionsRepository;

	@Override
	public Long addQuiz(Quiz quiz) {
		return null;
	}

	@Override
	public Long modifyQuiz(Quiz quiz) {
		return null;
	}

	@Override
	public void supprimerQuiz(Long idQuiz) {

	}

	@Override
	public List<Quiz> getQuiz() {
		return null;
	}

	@Override
	public Quiz getQuizById(Long idQuiz) {
		return null;
	}

	@Override
	public void getQuestionToQuiz(Long idQuestion, Long idQuiz) {

			Quiz quiz = quizRepository.findById(idQuiz).get();
			Questions questions = questionsRepository.findById(idQuestion).get();
			if(quiz != null && questions != null ) {
				questions.setQuiz(quiz);
				questionsRepository.save(questions);
			}
	}

}
