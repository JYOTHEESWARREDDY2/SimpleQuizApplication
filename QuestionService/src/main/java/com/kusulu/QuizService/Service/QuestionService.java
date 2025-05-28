package com.kusulu.QuizService.Service;
import com.kusulu.QuizService.Model.QuestionWrapper;
import com.kusulu.QuizService.Model.Questions;
import com.kusulu.QuizService.Model.Responses;
import com.kusulu.QuizService.Repository.QuestionRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
     @Autowired
     QuestionRepository repo;
    public ResponseEntity<List<Questions>> getAllQuestions() {
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getByCategory(String category) {

        try {
            return new ResponseEntity<>(repo.findBycategory(category),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions question) {
           try{
               repo.save(question);
               return new ResponseEntity<>("Success",HttpStatus.CREATED);
           }
           catch(Exception e){
               e.printStackTrace();
           }
           return new ResponseEntity<>("Not successFull",HttpStatus.INTERNAL_SERVER_ERROR);



    }

    public ResponseEntity<String> deleteQuestionById(int id) {


        try{
            repo.deleteById(id);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not successFull",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> updateById(Questions question ) {
        try{
            repo.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not successFull",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Integer>> createQuiz(String category, int noOfQuestions) {

        List<Integer> questions=repo.findRamdomQuestion(category,noOfQuestions);

        return new ResponseEntity<>(questions,HttpStatus.OK);

    }

    public ResponseEntity<List<QuestionWrapper>> generateQuestions(List<Integer> questionIds) {
        List<QuestionWrapper> question=new ArrayList<>();
        List<Optional<Questions>> q=new ArrayList<>();

        for(Integer s:questionIds) {
            Optional<Questions> allQuestions=repo.findById(s);
           q.add(allQuestions);
        }
        for( Optional<Questions> s:q){
            QuestionWrapper obj=new QuestionWrapper(s.get().getId(), s.get().getQuestion(),s.get().getOption1(),s.get().getOption2(),s.get().getOption3(),s.get().getOption4());
            question.add(obj);
        }

        return new ResponseEntity<>(question,HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<Responses> response) {
        int score=0;
        for(Responses res:response){
            Questions q=repo.findById(res.getId()).get();
            if(q.getCorrectOption().equals(res.getResponse())){
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
    }

