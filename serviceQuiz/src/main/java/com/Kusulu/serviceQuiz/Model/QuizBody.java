package com.Kusulu.serviceQuiz.Model;

import lombok.Data;

@Data
public class QuizBody {
    private String category;
    private int noQues;
    private String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoQues() {
        return noQues;
    }

    public void setNoQues(int noQues) {
        this.noQues = noQues;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
