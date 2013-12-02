package com.webq.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.webq.db.RetrieveDbInfo;

public class QuestionsCollection {
	private static RetrieveDbInfo retrieveDbInfo;
	private List<Question> questions = new ArrayList<Question>();
	
	public List<Question> getQuestions() {
		Collections.shuffle(questions);
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void init() {
		questions = new ArrayList<Question>();
		// populate questions here
	}
	
	public void addQuestion(Question q) {
		questions.add(q);
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
		List<Question> q = qcCollection.getQuestions();
		for (int i = 0; i < q.size(); i++) {
			Logger.getLogger(QuestionsCollection.class).debug(
					q.get(i).getQuestionDescription());
			Logger.getLogger(QuestionsCollection.class).debug(
					q.get(i).getOption1());
		}
	}
	
}
