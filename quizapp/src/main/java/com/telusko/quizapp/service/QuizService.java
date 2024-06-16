package com.telusko.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quizapp.dao.QuestionDAO;
import com.telusko.quizapp.dao.QuizDAO;
import com.telusko.quizapp.model.Quiz;
import com.telusko.quizapp.model.questiontable;

@Service
public class QuizService {
	
	@Autowired
	QuizDAO quizDAO;
	
	@Autowired
	QuestionDAO questionDAO;
	

	public ResponseEntity<String> createQuiz(String category, int noQ, String title) {
		// TODO Auto-generated method stub
		List<questiontable> questionsList = questionDAO.findRandomQuestionByCategory(category,noQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questionsList);
		quizDAO.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

}
