package tn.esprit.happyemployee.services;



import tn.esprit.happyemployee.entities.Answer;
import tn.esprit.happyemployee.entities.Question;

import java.util.List;

public interface IAnswerService {
	Answer save(Answer answer);

	Answer find(Long id) ;

	Answer update(Answer newAnswer) ;

	void delete(Answer answer) ;

	List<Answer> findAnswersByQuestion(Question question);

	int countAnswersInQuestion(Question question);
}
