package tn.esprit.happyemployee.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.entities.Response;
import tn.esprit.happyemployee.entities.Result;

import java.util.List;

public interface IQuizService {
//	Quiz save(Quiz quiz, User user);
Quiz save(Quiz quiz);

	Page<Quiz> findAll(Pageable pageable);

	Page<Quiz> findAllPublished(Pageable pageable);

//	Page<Quiz> findQuizzesByUser(User user, Pageable pageable);

	Quiz find(Long id);

	Quiz update(Quiz quiz) ;

	void delete(Quiz quiz) ;

	Page<Quiz> search(String query, Pageable pageable);

	Result checkAnswers(Quiz quiz, List<Response> answersBundle);

	void publishQuiz(Quiz quiz);
}
