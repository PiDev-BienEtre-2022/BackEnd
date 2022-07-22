package tn.esprit.happyemployee.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.happyemployee.entities.Question;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.entities.Response;
import tn.esprit.happyemployee.entities.Result;
import tn.esprit.happyemployee.repositories.QuizRepository;

import java.util.List;

@Service("QuizService")
@Transactional
public class QuizService implements IQuizService {

	private static final Logger logger = LoggerFactory.getLogger(QuizService.class);
	private QuizRepository quizRepository;

	private QuestionService questionService;

	@Autowired
	public QuizService(QuizRepository quizRepository, QuestionService questionService) {
		this.quizRepository = quizRepository;
		this.questionService = questionService;
	}

	@Override
//	public Quiz save(Quiz quiz, User user) {
  	public Quiz save(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Page<Quiz> findAll(Pageable pageable) {
		return quizRepository.findAll(pageable);
	}

	@Override
	public Page<Quiz> findAllPublished(Pageable pageable) {
		return quizRepository.findByIsPublishedTrue(pageable);
	}

	@Override
	public Quiz find(Long id) {
		Quiz quiz = quizRepository.findOne(id);

		if (quiz == null) {
			logger.error("Quiz " + id + " not found");

		}

		return quiz;
	}

	@Override
	public Quiz update(Quiz newQuiz) {
		Quiz currentQuiz = find(newQuiz.getIdQuiz());

		mergeQuizzes(currentQuiz, newQuiz);
		return quizRepository.save(currentQuiz);
	}

	@Override
	public void delete(Quiz quiz) {
		quizRepository.delete(quiz);
	}

	private void mergeQuizzes(Quiz currentQuiz, Quiz newQuiz) {
		currentQuiz.setName(newQuiz.getName());
		currentQuiz.setDescription(newQuiz.getDescription());
	}

	@Override
	public Page<Quiz> search(String query, Pageable pageable) {
		return quizRepository.searchByName(query, pageable);
	}

/*	@Override
	public Page<Quiz> findQuizzesByUser(User user, Pageable pageable) {
		return quizRepository.findByCreatedBy(user, pageable);
	}*/

	@Override
	public Result checkAnswers(Quiz quiz, List<Response> answersBundle) {
		Result results = new Result();

		for (Question question : quiz.getQuestions()) {
			boolean isFound = false;

			if (!question.getIsValid()) {
				continue;
			}

			for (Response bundle : answersBundle) {
				if (bundle.getQuestion().equals(question.getIdQuestion())) {
					isFound = true;
					results.addAnswer(questionService.checkIsCorrectAnswer(question, bundle.getSelectedAnswer()));
					break;
				}
			}

			/*if (!isFound) {
				throw new InvalidParametersException("No answer found for question: " + question.getText());
			}*/
		}

		return results;
	}

	@Override
	public void publishQuiz(Quiz quiz) {
		int count = questionService.countValidQuestionsInQuiz(quiz);

		if (count > 0) {
			quiz.setIsPublished(true);
			quizRepository.save(quiz);
		} /*else {
			throw new ActionRefusedException("The quiz doesn't have any valid questions");
		}*/
	}

}
