package com.Kusulu.serviceQuiz.Controller;
import com.Kusulu.serviceQuiz.Model.QuestionWrapper;
import com.Kusulu.serviceQuiz.Model.QuizBody;
import com.Kusulu.serviceQuiz.Model.Responses;
import com.Kusulu.serviceQuiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService service;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizBody quizs){
        return service.createQuiz(quizs.getCategory(),quizs.getNoQues(),quizs.getTitle());

    }
    @RequestMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable int id){
        return service.getById(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getTheScore(@PathVariable int id, @RequestBody  List<Responses> response){
        return service.getTheScore(id,response);
    }
}
