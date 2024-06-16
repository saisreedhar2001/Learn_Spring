package com.telusko.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.quizapp.model.questiontable;

@Repository
public interface QuestionDAO extends JpaRepository<questiontable, Integer> {
	
	List<questiontable> findByCategory(String category);

	@Query(value = "SELECT * FROM questiontable q WHERE q.category=:category ORDER BY RANDOM() LIMIT :noQ",nativeQuery = true)
	List<questiontable> findRandomQuestionByCategory(String category, int noQ);

}
