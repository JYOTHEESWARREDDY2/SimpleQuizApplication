package com.Kusulu.serviceQuiz.Repository;

import com.Kusulu.serviceQuiz.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {
}
