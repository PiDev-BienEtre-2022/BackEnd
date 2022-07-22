package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Answer;
import tn.esprit.happyemployee.entities.Question;
import tn.esprit.happyemployee.services.IAnswerService;
import tn.esprit.happyemployee.services.IQuestionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/challenge/answers")
public class AnswerController {

//	public static final String ROOT_MAPPING = "/api/answers";

	@Autowired
	IAnswerService answerService;

	@Autowired
	IQuestionService questionService;

	@PostMapping("/addanswer/{question_id}")
	@ResponseBody
	public Answer save(@Valid Answer answer, @RequestParam long question_id) {


		Question question = questionService.find(question_id);
		return questionService.addAnswerToQuestion(answer, question);
	}

	@PostMapping("/updateAllanswers")
	@ResponseBody
	public void updateAll(@RequestBody List<Answer> answers) {
		for (int i = 0; i < answers.size(); i++) {
			Answer answer = answers.get(i);
			answer.setOrder(i + 1);

			answerService.update(answer);
		}
	}
	@GetMapping("/findanswer/{demandeId}")
	@ResponseBody
	public Answer find(@PathVariable Long answer_id) {

		return answerService.find(answer_id);
	}

	@PostMapping("/updateanswer/{userId}")
	@ResponseBody
	public Answer update(@PathVariable Long answer_id, @Valid Answer answer) {


		answer.setIdAnswer(answer_id);
		return answerService.update(answer);
	}
	@DeleteMapping("/deleteanswer/{demandeId}")
	@ResponseBody
	public void delete(@PathVariable Long answer_id) {
		Answer answer = answerService.find(answer_id);
		answerService.delete(answer);
	}
}
