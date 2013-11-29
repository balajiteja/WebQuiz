package com.webq.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.webq.db.RetrieveDbInfo;

public class QuestionsCollection {
    private static RetrieveDbInfo retrieveDbInfo;
    private ArrayList<Question> questions = new ArrayList<Question>();

    public ArrayList<Question> getQuestions() {
	Collections.shuffle(questions);
	return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
	this.questions = questions;
    }

    public void init() {
	questions = new ArrayList<Question>();
	// populate questions here
    }

    public void addQuestion(Question q) {
	questions.add(q);
    }

    public void populateLevel1() {
    }

    public Iterator<Question> getQuestionIterator() {
	return questions.iterator();
    }

    public static RetrieveDbInfo getRetrieveDbInfo() {
	return retrieveDbInfo;
    }

    public static void setRetrieveDbInfo(RetrieveDbInfo retrieveDbInfo) {
	QuestionsCollection.retrieveDbInfo = retrieveDbInfo;
    }

    public static void main(String[] args) {
	QuestionsCollection qcCollection = new QuestionsCollection();
	qcCollection.init();
	qcCollection.populateLevel1();
	ArrayList<Question> q = qcCollection.getQuestions();
	for (int i = 0; i < q.size(); i++) {
	    System.out.println(q.get(i).getQuestionDescription());
	    System.out.println(q.get(i).getOption1());
	}
    }

    public void populateLevel2() {
	// TODO Auto-generated method stub

    }

    public void populateLevel3() {
	// TODO Auto-generated method stub

    }
}
