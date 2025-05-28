package com.Kusulu.serviceQuiz.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
   private String title;
   @ElementCollection
   private List<Integer> questionsid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestions() {

        return questionsid;

    }

    public void setQuestions(List<Integer> questions) {
        this.questionsid = questions;
    }
}
