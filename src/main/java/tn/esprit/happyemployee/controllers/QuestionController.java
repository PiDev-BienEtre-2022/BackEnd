package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Answer;
import tn.esprit.happyemployee.entities.Question;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.services.QuestionService;
import tn.esprit.happyemployee.services.QuizService;
import tn.esprit.happyemployee.services.AnswerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(QuestionController.ROOT_MAPPING)
public class QuestionController {

	public static final String ROOT_MAPPING = "/questions";

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	@Autowired
	private AnswerService answerService;

	@PostMapping("/addquestion/{quiz_id}")
	@ResponseBody
	public Question save(@RequestBody Question question, @PathVariable Long quiz_id) {

		Quiz quiz = quizService.find(quiz_id);
		question.setQuiz(quiz);
		return questionService.save(question);

	}

	@PostMapping("/updateAllquestions")
	@ResponseBody
	public void updateAll(@RequestBody List<Question> questions) {
		for (int i = 0; i < questions.size(); i++) {
			Question question = questions.get(i);
			question.setOrder(i + 1);
			questionService.update(question);
		}
	}

	@GetMapping("/findquestion/{question_id}")
	@ResponseBody
	public Question find(@PathVariable Long question_id) {

		return questionService.find(question_id);
	}

	@PostMapping("/updatequestion/{question_id}")
	@ResponseBody
	public Question update(@PathVariable Long question_id, @RequestBody  Question question) {

		question.setIdQuestion(question_id);
		return questionService.update(question);

	}
	@DeleteMapping("/deletequestion/{question_id}")
	@ResponseBody
	public void delete(@PathVariable Long question_id) {
		Question question = questionService.find(question_id);
		questionService.delete(question);
	}

	@GetMapping("/getanswersforquestions{question_id}")
	@ResponseBody
	public List<Answer> findAnswers(@PathVariable Long question_id) {
		Question question = questionService.find(question_id);
		return answerService.findAnswersByQuestion(question);
	}

	@GetMapping("/getcorrectanswerforquestion/{question_id}")
	@ResponseBody
	public Answer getCorrectAnswer(@PathVariable Long question_id) {
		Question question = questionService.find(question_id);
		return questionService.getCorrectAnswer(question);
	}

	@PostMapping("/setcorrectanswerforquestion/question_id")
	@ResponseBody
	public void setCorrectAnswer(@PathVariable Long question_id, @RequestParam Long answer_id) {

		Question question = questionService.find(question_id);
		Answer answer = answerService.find(answer_id);
		questionService.setCorrectAnswer(question, answer);
	}

}
