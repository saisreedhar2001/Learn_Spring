package com.telusko.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quizapp.dao.QuestionDAO;
import com.telusko.quizapp.dao.QuizDAO;
import com.telusko.quizapp.model.QuestionTableWrapper;
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


	public ResponseEntity<List<QuestionTableWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDAO.findById(id);
		List<questiontable> questionsFromDB= quiz.get().getQuestions();
		List<QuestionTableWrapper> questionsForUser = new ArrayList<>();
		
		for(questiontable q : questionsFromDB) {
			QuestionTableWrapper qWrapper = new QuestionTableWrapper(q.getId(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qWrapper);
		}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}

}
