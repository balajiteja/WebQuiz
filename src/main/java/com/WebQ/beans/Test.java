package com.WebQ.beans;

import java.util.Date;
import java.util.Timer;

public class Test {
    private Date startTime;
    private Timer timer;
    private int level;
    private QuestionsCollection questionsCollection;

    public void init() {
	// Gather questions
    }

    public QuestionsCollection getQuestionsCollection() {
	return questionsCollection;
    }

    public void setQuestionsCollection(QuestionsCollection questionsCollection) {
	this.questionsCollection = questionsCollection;
    }

    public Date getStartTime() {
	return startTime;
    }

    public void setStartTime(Date startTime) {
	this.startTime = startTime;
    }

    public Timer getTimer() {
	return timer;
    }

    public void setTimer(Timer timer) {
	this.timer = timer;
    }

    public int getLevel() {
	return level;
    }

    public void setLevel(int level) {
	this.level = level;
    }

}
