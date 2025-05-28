package com.kusulu.QuizService.Repository;
import com.kusulu.QuizService.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {
    List<Questions> findBycategory(String category);
    @Query(value = "SELECT q.id FROM Questions q WHERE q.category = :category ORDER BY RAND() LIMIT :noQues", nativeQuery = true)
    List<Integer> findRamdomQuestion(String category, int noQues);
}
