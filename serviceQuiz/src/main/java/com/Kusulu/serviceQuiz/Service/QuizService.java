package com.Kusulu.serviceQuiz.Service;
import com.Kusulu.serviceQuiz.Feign.QuizInterface;
import com.Kusulu.serviceQuiz.Model.QuestionWrapper;
import com.Kusulu.serviceQuiz.Model.Quiz;
import com.Kusulu.serviceQuiz.Model.Responses;
import com.Kusulu.serviceQuiz.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
   // @Autowired
    //QuestionRepository quizQuestions;
    @Autowired
    QuizRepo repo;
    @Autowired
    QuizInterface quizInterface;
    public ResponseEntity<String> createQuiz(String category, int noQues, String title) {
        List<Integer> questions=quizInterface.CreateQuiz(category,noQues).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        repo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getById(int id) {
          Optional<Quiz> quiz=repo.findById(id);
        //System.out.println(quiz);
       List<Integer> question=quiz.get().getQuestions();
       ResponseEntity<List<QuestionWrapper>>questionFromDb=quizInterface.generateQuestions(question);
        //for(Questions q:question){
        //    QuestionWrapper a=new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
        //    questionFromDb.add(a);
       // }

        return questionFromDb;
    }

    public ResponseEntity<Integer> getTheScore(int id, List<Responses> response) {
       // Optional<Quiz> quiz=repo.findById(id);
        //List<Integer> questions=quiz.get().getQuestions();

        //int score=0;
        //int i=0;
        //for(Responses res:response){
           // if(questions.get(i).getCorrectOption().equals(response.get(i).getResponse())){
             //   score++;
           // }
           // i++;
        //}
        return quizInterface.getScore(response);
    }
}
