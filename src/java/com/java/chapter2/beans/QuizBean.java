/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.chapter2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author IOAdmin
 */
@ManagedBean
@SessionScoped
public class QuizBean implements Serializable {

    private ArrayList<ProblemBean> problems = new ArrayList<>();
    private int currentIndex;
    private int score;
    
    /**
     * Creates a new instance of QuizBean
     */
    public QuizBean() {
        problems.add(
            new ProblemBean(new int[] {3, 1, 4, 1, 5}, 9)); // numbers PI
        problems.add(
            new ProblemBean(new int[] {1, 1, 2, 3, 5}, 8)); // numbers FIB
    }

    public void setProblems(ArrayList<ProblemBean> newValue) {
        problems = newValue;
        currentIndex = 0;
        score = 0;
    }

    public ProblemBean getCurrent() {
        return problems.get(currentIndex);
    }

    public int getScore() {
        return score;
    }
    
    public String getAnswer() { return ""; }
    public void setAnswer(String newValue) {
        try {
            int answer = Integer.parseInt(newValue.trim());
            if (getCurrent().getSolution() == answer) score++;
            currentIndex = (currentIndex + 1) % problems.size();
        } catch (NumberFormatException e) {
            // nop
        }
    }
}
