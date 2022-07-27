package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.FilterTeletravail;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.entities.Response;
import tn.esprit.happyemployee.entities.Result;

import java.util.List;

public interface IQuizService {
//	Quiz save(Quiz quiz, User user);
	Quiz addQuiz(Quiz quiz);

	List<Quiz> findAll();

	List<Quiz> findAllPublished();

//	Page<Quiz> findQuizzesByUser(User user, Pageable pageable);

	Quiz find(Long id);

	Quiz update(Quiz quiz) ;

	void delete(Quiz quiz) ;

	List<Quiz> search(String query);

	Result checkAnswers(Quiz quiz, List<Response> answersBundle);

	void publishQuiz(Quiz quiz);
}
