package com.WebQ.beans;

import java.util.ArrayList;
import java.util.Iterator;

import com.WebQ.db.RetrieveDbInfo;

public class QuestionsCollection {
    private static RetrieveDbInfo retrieveDbInfo;
    private ArrayList<Question> questions = new ArrayList<Question>();

    public ArrayList<Question> getQuestions() {
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
	// questions = new HashMap<String, Question>();

	// for (int i = 0; i < 5; i++) {
	// questions.add(new Question(i, 1, (i + 1) + "questionDescription",
	// "option1", "option2", "option3", "option4", "option1"));
	// }
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
