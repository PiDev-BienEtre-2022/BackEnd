package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.happyemployee.services.IQuizService;

@RestController
public class QuizController {
    @Autowired
    IQuizService quizService;
}
