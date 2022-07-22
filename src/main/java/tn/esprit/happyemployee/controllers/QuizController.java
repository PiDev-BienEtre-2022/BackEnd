package tn.esprit.happyemployee.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Question;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.entities.Response;
import tn.esprit.happyemployee.entities.Result;
import tn.esprit.happyemployee.services.QuestionService;
import tn.esprit.happyemployee.services.QuizService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(QuizController.ROOT_MAPPING)
public class QuizController {

	public static final String ROOT_MAPPING = "/api/quizzes";
	
	private static final Logger logger = LoggerFactory.getLogger(QuizController.class);

	@Autowired
	private QuizService quizService;

	@Autowired
	private QuestionService questionService;

	@GetMapping("/findallquiz")
	@ResponseBody
	public Page<Quiz> findAll(Pageable pageable,
							  @RequestParam(required = false, defaultValue = "false") Boolean published) {
		
		if (published) {
			return quizService.findAllPublished(pageable);
		} else {
			return quizService.findAll(pageable);
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Page<Quiz> searchAll(Pageable pageable, @RequestParam(required = true) String filter,
			@RequestParam(required = false, defaultValue = "false") Boolean onlyValid) {

		return quizService.search(filter, pageable);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PostMapping("/addquiz")
	@ResponseBody
	public Quiz save(@Valid Quiz quiz) {

		logger.debug("The Quiz " + quiz.getName() + " is going to be created");


		return quizService.save(quiz);
	}
/*	public Quiz save(@AuthenticationPrincipal AuthenticatedUser user, @Valid Quiz quiz, BindingResult result) {

		logger.debug("The Quiz " + quiz.getName() + " is going to be created");
		
		RestVerifier.verifyModelResult(result);

		return quizService.save(quiz, user.getUser());
	}*/

	@RequestMapping(value = "/{quiz_id}", method = RequestMethod.GET)
	@GetMapping("findquiz/{quiz_id}")
	@ResponseBody
	public Quiz find(@PathVariable Long quiz_id) {

		return quizService.find(quiz_id);
	}

	@PostMapping("/updatequiz/{quiz_id}")
	@ResponseBody
	public Quiz update(@PathVariable Long quiz_id, @Valid Quiz quiz) {


		quiz.setIdQuiz(quiz_id);
		return quizService.update(quiz);
	}

	@DeleteMapping("/deletequiz/{quiz_id}")
	@ResponseBody
	public void delete(@PathVariable Long quiz_id) {
		Quiz quiz = quizService.find(quiz_id);
		quizService.delete(quiz);
	}

	@GetMapping("findquestionbyquiz/{quiz_id}/questions")
	@ResponseBody
	public List<Question> findQuestions(@PathVariable Long quiz_id,
										@RequestParam(required = false, defaultValue = "false") Boolean onlyValid) {

		Quiz quiz = quizService.find(quiz_id);

		if (onlyValid) {
			return questionService.findValidQuestionsByQuiz(quiz);
		} else {
			return questionService.findQuestionsByQuiz(quiz);
		}

	}

	@PostMapping("/publish/{quiz_id}")
	@ResponseBody
	public void publishQuiz(@PathVariable long quiz_id) {
		Quiz quiz = quizService.find(quiz_id);
		quizService.publishQuiz(quiz);
	}

	@PostMapping("/submitAnswers/{quiz_id}")
	@ResponseBody
	public Result playQuiz(@PathVariable long quiz_id, @RequestBody List<Response> answersBundle) {
		Quiz quiz = quizService.find(quiz_id);
		return quizService.checkAnswers(quiz, answersBundle);
	}

}
