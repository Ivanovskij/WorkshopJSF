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
public class ProblemBean implements Serializable {

    private ArrayList<Integer> sequence;
    private int solution;
    
    /**
     * Creates a new instance of QuizBean
     */
    public ProblemBean() {
    }

    public ProblemBean(int[] values, int solution) {
        sequence = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            sequence.add(values[i]);
        }
        this.solution = solution;
    }

    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    public void setSequence(ArrayList<Integer> sequence) {
        this.sequence = sequence;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }
}
