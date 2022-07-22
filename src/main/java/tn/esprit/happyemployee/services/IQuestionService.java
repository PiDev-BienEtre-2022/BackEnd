package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.Answer;
import tn.esprit.happyemployee.entities.Question;
import tn.esprit.happyemployee.entities.Quiz;

import java.util.List;

public interface IQuestionService {
	Question save(Question question) ;

	Question find(Long id) ;

	List<Question> findQuestionsByQuiz(Quiz quiz);

	List<Question> findValidQuestionsByQuiz(Quiz quiz);

	Question update(Question question);

	void delete(Question question) ;

	Boolean checkIsCorrectAnswer(Question question, Long answer_id);

	void setCorrectAnswer(Question question, Answer answer);

	Answer getCorrectAnswer(Question question);

	Answer addAnswerToQuestion(Answer answer, Question question);

	int countQuestionsInQuiz(Quiz quiz);

	int countValidQuestionsInQuiz(Quiz quiz);
}
