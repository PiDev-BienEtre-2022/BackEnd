package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Answer;
import tn.esprit.happyemployee.entities.Question;
import tn.esprit.happyemployee.services.AnswerService;
import tn.esprit.happyemployee.services.QuestionService;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

//	public static final String ROOT_MAPPING = "/api/answers";

	@Autowired
	AnswerService answerService;

	@Autowired
	QuestionService questionService;

	@PostMapping("/addanswer/{question_id}")
	@ResponseBody
	public Answer save(@PathVariable long question_id,@RequestBody Answer answer) {


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

	@GetMapping("/findanswer/{answer_id}")
	@ResponseBody
	public Answer findById(@PathVariable Long answer_id) {

		return answerService.find(answer_id);
	}

	@PostMapping("/updateanswer/{answer_id}")
	@ResponseBody
	public Answer update(@PathVariable Long answer_id, @RequestBody  Answer answer) {
		answer.setIdAnswer(answer_id);
		return answerService.update(answer);
	}

	@DeleteMapping("/deleteanswer/{answer_id}")
	@ResponseBody
	public void delete(@PathVariable Long answer_id) {
		Answer answer = answerService.find(answer_id);
		answerService.delete(answer);
	}
}
