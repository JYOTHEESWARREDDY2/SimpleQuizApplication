package com.Kusulu.serviceQuiz.Feign;

import com.Kusulu.serviceQuiz.Model.QuestionWrapper;
import com.Kusulu.serviceQuiz.Model.Responses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONSERVICE")
public interface QuizInterface {
    @PostMapping("/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Responses> response);
    @PostMapping("/generate")
    public ResponseEntity<List<QuestionWrapper>> generateQuestions(@RequestBody List<Integer> QuestionIds);
    @RequestMapping("/creates")
    public ResponseEntity<List<Integer>>CreateQuiz(@RequestParam String Category, @RequestParam int noOfQuestions);



}
