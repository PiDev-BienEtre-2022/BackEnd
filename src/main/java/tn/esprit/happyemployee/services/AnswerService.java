package tn.esprit.happyemployee.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.happyemployee.entities.Answer;
import tn.esprit.happyemployee.entities.Question;
import tn.esprit.happyemployee.exception.ActionRefusedException;
import tn.esprit.happyemployee.exception.ResourceUnavailableException;
import tn.esprit.happyemployee.exception.UnauthorizedActionException;
import tn.esprit.happyemployee.repositories.AnswerRepository;

import java.util.List;

@Service("AnswerService")
@Transactional
public class AnswerService implements IAnswerService {

	private static final Logger logger = LoggerFactory.getLogger(AnswerService.class);
	private AnswerRepository answerRepository;

	@Autowired
	private IQuestionService questionService;

	@Autowired
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public Answer find(Long id) throws ResourceUnavailableException {
		Answer answer = answerRepository.findOne(id);

		if (answer == null) {
			logger.error("Answer " + id + " not found");
			throw new ResourceUnavailableException("Answer " + id + " not found");
		}

		return answer;
	}

	@Override
	public Answer save(Answer answer) throws UnauthorizedActionException {
		return answerRepository.save(answer);
	}

	@Override
	public Answer update(Answer newAnswer) throws ResourceUnavailableException, UnauthorizedActionException {
		Answer currentAnswer = find(newAnswer.getIdAnswer());

		mergeAnswers(currentAnswer, newAnswer);
		return answerRepository.save(currentAnswer);
	}

	@Override
	public void delete(Answer answer) throws ResourceUnavailableException, UnauthorizedActionException {

		if (questionService.checkIsCorrectAnswer(answer.getQuestion(), answer.getIdAnswer())) {
			throw new ActionRefusedException("The correct answer can't be deleted");
		}

		answerRepository.delete(answer);
	}

	private void mergeAnswers(Answer currentAnswer, Answer newAnswer) {
		currentAnswer.setText(newAnswer.getText());

		if (newAnswer.getOrder() != null) {
			currentAnswer.setOrder(newAnswer.getOrder());
		}
	}

	@Override
	public List<Answer> findAnswersByQuestion(Question question) {
		return answerRepository.findByQuestionOrderByOrderAsc(question);
	}

	@Override
	public int countAnswersInQuestion(Question question) {
		return answerRepository.countByQuestion(question);
	}

}
