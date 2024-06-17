package com.telusko.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quizapp.model.QuestionTableWrapper;
import com.telusko.quizapp.model.questiontable;
import com.telusko.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	 
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String Category,@RequestParam int noQ,@RequestParam String Title) {
		return quizService.createQuiz(Category,noQ,Title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionTableWrapper>> getQuizQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	}

}
