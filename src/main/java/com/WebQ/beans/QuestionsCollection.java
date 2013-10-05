package com.WebQ.beans;

import java.util.Map;

public class QuestionsCollection {
    private static Map<String, Question> questions;

    public static Map<String, Question> getQuestions() {
	return questions;
    }

    public static void setQuestions(Map<String, Question> questions) {
	QuestionsCollection.questions = questions;
    }

    public void init() {
	// populate questions here
    }
}
