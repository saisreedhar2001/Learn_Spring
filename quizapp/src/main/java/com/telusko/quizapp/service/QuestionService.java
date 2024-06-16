package com.telusko.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quizapp.dao.QuestionDAO;
import com.telusko.quizapp.model.questiontable;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<List<questiontable>> getAllQuestions() {
		// TODO Auto-generated method stubss
		try {
			return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<questiontable>> getAllQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.BAD_REQUEST);
	}

	
	public ResponseEntity<String> addQuestion(questiontable questiontable) {
		// TODO Auto-generated method stub
		questionDAO.save(questiontable);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

}
