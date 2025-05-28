package com.kusulu.QuizService.Controller;
import com.kusulu.QuizService.Model.QuestionWrapper;
import com.kusulu.QuizService.Model.Questions;
import com.kusulu.QuizService.Model.Responses;
import com.kusulu.QuizService.Service.QuestionService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class questionController {
    @Autowired
    QuestionService service;
    @RequestMapping("/questions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return service.getAllQuestions();
    }
    @RequestMapping("/questions/{category}")
    public ResponseEntity<List<Questions>> getByCategory(@PathVariable String category){

        return service.getByCategory(category);
    }
    @PostMapping("/questions/add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){

        return service.addQuestion(question);
    }
    @DeleteMapping("/questions/Delete/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable int id){
        return service.deleteQuestionById(id);
    }
  @PutMapping("question/update")
        public ResponseEntity<String> updateById(@RequestBody Questions question){
            return service.updateById(question);
      }
      @RequestMapping("/creates")
    public ResponseEntity<List<Integer>>CreateQuiz(@RequestParam String Category,@RequestParam int noOfQuestions){
        return service.createQuiz(Category,noOfQuestions);

      }
      @PostMapping("/generate")
    public ResponseEntity<List<QuestionWrapper>> generateQuestions(@RequestBody List<Integer> QuestionIds){
        return service.generateQuestions(QuestionIds);
      }
      @PostMapping("/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Responses> response){

        return service.getScore(response);
      }
  }

